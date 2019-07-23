package com.lee.controller;

import java.awt.TexturePaint;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Identifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lee.mapper.SmsMusicMapper;
import com.lee.pojo.Like;
import com.lee.pojo.Music;
import com.lee.pojo.SmsMusic;
import com.lee.pojo.User;
import com.lee.service.SmsMusicService;
import com.lee.service.ToolsService;

/* @Description:上传私信音乐
 * @author: loved
 * @date: 2019年3月13日 下午11:34:09
 */
@Controller
@RequestMapping("")
public class SmsMusicController {
	@Autowired
	private SmsMusicService smsMusicService;
	@Autowired
	private ToolsService toolsService;
	
	/**@Description:上传音乐到vip库
	 * @date 2019年3月14日 下午9:17:07*/
	/*@ResponseBody*/
	@RequestMapping("/sendSmsMusic")
	public ModelAndView addSmsMusic(SmsMusic smsMusic,HttpServletRequest request) throws Exception {
		//temp:上传者ID，存在浏览器验证已登录的用户
		
		System.out.println("get:"+smsMusic.toString()+"request:"+request.getParameter("temp_user_id"));
		int user_id =Integer.parseInt(request.getParameter("temp_user_id"));
		smsMusic.setFk_user_id(user_id);
		//新建VIP专用文件夹,本地用绝对路径，阿里云用相对路径
		File vipFiles = new File("E:/EclipseGDOU/MusicSharing/WebContent/static/vipFiles");//vip文件夹
		if (!vipFiles.exists()) {
//			File parent = new File("WebContent");
			vipFiles = new File("webapps/MusicSharing/static/vipFiles");
			System.out.println("vipFiles Path:"+vipFiles.getAbsolutePath());
		} 
		String folderName =Integer.toString(smsMusic.getFk_user_id());//根据上传者ID创建专用文件夹
		File folderPersonal = new File(vipFiles, folderName);
		if (!folderPersonal.exists()) {//如果文件夹不存在则新建一个
			folderPersonal.mkdirs();
		}
		
		MultipartFile picture = smsMusic.getPicture();//获取文件对象
		MultipartFile music = smsMusic.getMusic();
		
		System.out.println("piture info:"+picture.getSize());//打印对象信息
		System.out.println("music info:"+music.getSize());
		
		String picName = picture.getOriginalFilename();//获取文件名
		String musName = music.getOriginalFilename();
		
		if (smsMusic.getTitle().length()==0) {
			smsMusic.setTitle(musName);
		}//如果歌曲名为空，则默认用歌曲名
		
		File filePic = new File(folderPersonal, picName);//新建要保存的文件对象
		File fileMus = new File(folderPersonal, musName);
		
		picture.transferTo(filePic);//保存文件到上一步新建的对象中
		music.transferTo(fileMus);
		
		//保存到数据库
		smsMusic.setPicture_path("vipFiles/"+folderName+"/"+picName);
		smsMusic.setMusic_path("vipFiles/"+folderName+"/"+musName);
		
		int result = smsMusicService.addSmsMusic(smsMusic);
		System.out.println("restore finish");
		//设置点播收听页的url
		int newSmsId = toolsService.getNewSmsId(user_id);//调用工具获取当次的sms_id
		String hostName = toolsService.getHostName(smsMusic.getUrl());//获取该url的主机名
		String url=hostName+"page/sound.html?sms_id="+(newSmsId);
		System.out.println("url="+url);
		smsMusic.setUrl(url);
			
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("url", url);
		modelAndView.setViewName("toSound");
		return modelAndView;
		//返回操作结果信息
		/*HashMap<String, Object> map = new HashMap<>();
		map.put("status", true);
		map.put("msg", smsMusic.getUrl());*/
	}
	
	/**@Description:输入用户user_id，我的点播，和点播回信查询
	 * @date 2019年3月14日 下午9:24:11*/
	@ResponseBody
	@RequestMapping("/listSmsMusic")
	public HashMap<String,Object > listSmsMusic(@RequestBody User user,HttpServletRequest request) {
		System.out.println("get:"+user.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		String token = user.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status",true);
			List<SmsMusic> listSmsMusic = smsMusicService.listSmsMusic(user);
			map.put("msg", listSmsMusic);
		}else {
			map.put("status", false);
			map.put("msg", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:根据用户输入的电话和命令，正确则返回歌曲信息（把sms_id,receive_tel和command作为参数加入）
	 * @date 2019年3月14日 下午9:35:43*/
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping("/selectSmsMusicByTelAndCommand")
	public HashMap<String,Object> selectSmsMusicByTelAndCommand(@RequestBody SmsMusic smsMusic) {
		System.out.println("get："+smsMusic.toString());
		
		
		HashMap<String, Object> map = new HashMap<>();
		if (smsMusic!=null) {
			map.put("status", true);
			SmsMusic ifExist = smsMusicService.selectSmsMusicByTelAndCommand(smsMusic);
			map.put("msg", ifExist);//存在，则把歌曲信息保存返回
		}else {
			map.put("status", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:把letter和sms_id作为参数加入，返回信息发送结果
	 * @date 2019年3月14日 下午9:40:14*/
	@ResponseBody
	@RequestMapping("/updateSmsMusicByLetter")
	public HashMap<String, Boolean> updateSmsMusicByLetter(@RequestBody SmsMusic letterAndAmsId) {
		System.out.println("get："+letterAndAmsId.toString());
		
		int updateSmsMusicByLetter = smsMusicService.updateSmsMusicByLetter(letterAndAmsId);
		System.out.println("update finish");
		
		HashMap<String, Boolean> map = new HashMap<>();
		if (updateSmsMusicByLetter>0) {
			map.put("msg", true);
		}else {
			map.put("msg", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:点播收听页面，输入sms_id和command,返回歌曲信息
	 * @param:token，sms_id,command
	 * @return:
	 * @date 2019年3月31日 上午1:14:21*/
	@ResponseBody
	@RequestMapping("/selectSmsMusicBySmsIdAndCommand")
	public HashMap<String,Object> selectSmsMusicBySmsIdAndCommand(@RequestBody SmsMusic smsMusic,HttpServletRequest request) {
		System.out.println("get："+smsMusic.toString());
		
		String url=smsMusic.getUrl();//获取url信息并提取出sms_id
		String sms_idStr = toolsService.getSms_id(url);
		int sms_id = Integer.parseInt(sms_idStr);
		smsMusic.setSms_id(sms_id);
		
		Object attribute = request.getAttribute("token");//测试
		System.out.println("token="+attribute);
		
		boolean checkToken = toolsService.CheckToken(smsMusic.getToken(), request);
//		checkToken=true;//假设token值为真
		HashMap<String, Object> map = new HashMap<>();
		SmsMusic music = smsMusicService.selectSmsMusicBySmsIdAndCommand(smsMusic);
		map.put("msg", music);
		if (checkToken) {
			map.put("status", true);//token值验证成功为登录用户，前端接收到true时则可以使用短信和分享功能
		}else {
			map.put("status", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	
	/**@Description:歌词编辑页面使用，输入sms_id得到必要的歌曲信息
	 * @param:
	 * @return:
	 * @date 2019年4月4日 下午11:23:27*/
	@ResponseBody
	@RequestMapping("/selectSmsMusicBySmsId")
	public HashMap<String,Object> selectSmsMusicBySmsId(@RequestBody SmsMusic smsMusic) {
		System.out.println("get："+smsMusic.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		SmsMusic music = smsMusicService.selectSmsMusicBySmsId(smsMusic);
		SmsMusic callback = new SmsMusic();
			callback.setSms_id(music.getSms_id());
			callback.setTitle(music.getTitle());
			callback.setMusic_path(music.getMusic_path());
	
			map.put("msg", callback);
		System.out.println("map:"+map.toString());
		return map;
	}
}

