package com.lee.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lee.pojo.Music;
import com.lee.service.MusicService;

/* @Description:上传音乐
 * @author: loved
 * @date: 2019年3月13日 下午3:55:26
 */
@Controller
@RequestMapping("")
public class RocketController {
	@Autowired
	private MusicService musicService;
	
	/**@Description:接收前端图片
	 * @date 2019年3月13日 下午4:55:43*/
//	@ResponseBody
	@RequestMapping("/sendMusic") 
	public ModelAndView uploadRocketMusic(Music info,HttpServletRequest request)throws Exception{
		//temp:上传者ID，存在浏览器验证已登录的用户的
//		info.setFk_user_id(10);
		System.out.println("get："+info.toString());
		
//		新建文件夹，本地用绝对路径，阿里云使用相对路径
		File parent = new File("E:/EclipseGDOU/MusicSharing/WebContent/static");//资源父目录
		if (!parent.exists()) {
//			File parentNew = new File("WebContent");
			parent = new File("webapps/MusicSharing/static");
		} 
		
		File imagesPath = new File(parent, "images");//图片文件夹
		File filePath = new File(parent, "files");//音乐文件夹
		if (!filePath.exists()) {
			filePath.mkdirs();
		}else if (!imagesPath.exists()) {
			imagesPath.mkdirs();
		}//如果无文件夹则创建相关文件夹
		System.out.println("imagesPath:"+imagesPath.getAbsolutePath());
		System.out.println("imagesPath exist:"+imagesPath.exists());
		MultipartFile picture = info.getPicture();//获取文件对象
		MultipartFile music = info.getMusic();
		
		System.out.println("piture info:"+picture.getSize());//打印对象信息
		System.out.println("music info:"+music.getSize());
		
		String picName = picture.getOriginalFilename();//获取文件名
		String musName = music.getOriginalFilename();
		System.out.println(info.getName().toString()+""+info.getName().length());
		if (info.getName().length()==0) {
			info.setName(musName);
		}//如果歌曲名为空，则默认用歌曲名
		
		File filePic = new File(imagesPath, picName);//新建要保存的文件对象
		File fileMus = new File(filePath, musName);
		
		picture.transferTo(filePic);//保存文件到上一步新建的对象中
		music.transferTo(fileMus);
		
		
		//保存到数据库
		info.setCover("images/"+picName);//保存路径到pojo
		info.setFile("files/"+musName);
		
		int addMusic = musicService.addMusic(info);
		System.out.println("add finish:"+info.toString());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg","true");
		modelAndView.setViewName("toIndex");//返回首页
		return modelAndView;
	}
	
}

