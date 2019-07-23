package com.lee.controller;


import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lee.pojo.User;
import com.lee.service.UserService;

/* @Description:注册和登录
 * @author: loved
 * @date: 2019年3月12日 下午3:32:11
 */
@Controller
@RequestMapping("")
public class RegisterAndLoginController {
	@Autowired
	private UserService userService;
	
	/**@Description:注册;status=1即按预期处理了请求,=0则处理失败
	 * @date 2019年3月18日 下午12:04:09*/
	@ResponseBody
	@RequestMapping("/register")
	public HashMap<String, Object> register(@RequestBody User user) {
		System.out.println("get:"+user.toString());//测试数据是否接受成功
		User userNew =userService.selectUserByName(user.getName());//返回的用户信息
		HashMap<String, Object> callback = new HashMap<>();
		if (userNew==null) {
			userService.addUser(user);//新增用户操作
			User userBack =userService.selectUserByName(user.getName());//返回的用户信息
			callback.put("user", userBack);
			callback.put("status", 1);
		} else {
			callback.put("status", 0);
		}
		
		System.out.println("callback:"+callback.toString());
		return callback;
	}
	
	/**@Description:登录验证账户名和密码，返回token
	 * @date 2019年3月18日 下午12:29:01*/
	@ResponseBody
	@RequestMapping("/login")
	public HashMap<String, Object> login(@RequestBody User user,HttpServletRequest request) {
		System.out.println("get:"+user.toString());
		UUID token = UUID.randomUUID();//生成token值
		request.getSession().setAttribute("token", token.toString());
		System.out.println("finish:"+token.toString());
		
		User confirm = userService.selectUserByNameAndPassword(user);//验证用户名和密码
		
		HashMap<String, Object> callback = new HashMap<>();
		
		if (confirm!=null) {
			callback.put("user", confirm);
			callback.put("status", 1);
			callback.put("token", token);
			System.out.println("login finish");
		} else {
			callback.put("status", 0);
			System.out.println("login fail");
		}
		
		System.err.println("map:"+callback.toString());
		return callback;
	}
	
	/**@Description:注册时验证账户名是否已存在
	 * @date 2019年3月18日 下午12:36:55*/
	@ResponseBody
	@RequestMapping("/verify/username")
	public HashMap<String, Object> ifNameExist(@RequestBody User user) {
		System.out.println("get:"+user.toString());
		String name = user.getName();
		User result = userService.selectUserByName(name);//根据用户名返回的数据
		
		HashMap<String, Object> callback = new HashMap<>();
		if (result!=null) {
			callback.put("msg", 1);//名字已存在
			callback.put("status", false);//名字已存在
		} else {
			callback.put("msg", 0);//名字不存在
			callback.put("status", true);
		}
		
		System.out.println("map:"+callback.toString());
		return callback;
	}

}

