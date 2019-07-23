package com.lee.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.pojo.Letter;
import com.lee.pojo.User;
import com.lee.service.LetterService;
import com.lee.service.ToolsService;
import com.lee.service.UserService;

/* @Description:私信模块控制类
 * @author: loved
 * @date: 2019年3月14日 下午9:01:52
 */
@Controller
@RequestMapping("")
public class LetterController {
	@Autowired
	private LetterService letterService;
	@Autowired
	private UserService userService;
	@Autowired
	private ToolsService toolsService;
	
	/**@Description:输入letter的信息，发送人，收件人和内容，返回发送成功提示
	 * @date 2019年3月14日 下午9:06:49*/
	@ResponseBody
	@RequestMapping("/addLetter")
	public HashMap<String, Boolean> addLetter(@RequestBody Letter letter,HttpServletRequest request) {
		System.out.println("get:"+letter.toString());
		HashMap<String, Boolean> map = new HashMap<>();
		
		String token = letter.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			letterService.addLetter(letter);
			map.put("msg", true);
		}else {
			map.put("status", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:输入本人user_id,返回自己的收件信息
	 * @date 2019年3月14日 下午9:09:40*/
	@ResponseBody
	@RequestMapping("/selectLetterByReceive")
	public HashMap<String, Object> selectLetterByReceive(@RequestBody User user,HttpServletRequest request) {
		System.out.println("get:"+user.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		String token = user.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			List<Letter> receive = letterService.selectLetterByReceive(user);
			for (int i = 0; i < receive.size(); i++) {
				User userInfo = userService.getUserInfo(receive.get(i).getFk_user_send());//获取相应id的用户信息
				receive.get(i).setSendName(userInfo.getName());//把Name set进letter信息里
			}
			map.put("msg", receive);
		}else {
			map.put("status", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:输入本人user_id，返回自己的发件信息
	 * @date 2019年3月14日 下午9:12:09*/
	@ResponseBody
	@RequestMapping("/selectLetterBySend")
	public HashMap<String, Object> selectLetterBySend(@RequestBody User user,HttpServletRequest request) {
		System.out.println("get:"+user.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		String token = user.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			List<Letter> send = letterService.selectLetterBySend(user);
			for (int i = 0; i < send.size(); i++) {
				User userInfo = userService.getUserInfo(send.get(i).getFk_user_receive());
				send.get(i).setReceiveName(userInfo.getName());
			}
			map.put("msg", send);
		}else {
			map.put("status", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
}

