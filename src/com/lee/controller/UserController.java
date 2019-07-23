package com.lee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.pojo.FromTo;
import com.lee.pojo.StartCount;
import com.lee.pojo.User;
import com.lee.service.FileService;
import com.lee.service.ToolsService;
import com.lee.service.UserService;
import com.lee.util.Page;

/* @Description:用户相关的常用控制类
 * @author: loved
 * @date: 2019年3月14日 下午7:22:25
 */
@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private FileService fileservice;
	@Autowired
	private ToolsService toolService;
	
	/**@Description:删除用户
	 * @param:token,user_id
	 * @return:
	 * @date 2019年3月21日 下午7:58:41*/
	@ResponseBody
	@RequestMapping("/deleteUserById")
	public HashMap<String, Boolean> deleteUserById(@RequestBody User user,HttpServletRequest request) {
		System.out.println("get："+user.toString());
		HashMap<String, Boolean> map = new HashMap<>();
		
		String token = user.getToken();
		boolean checkToken = toolService.CheckToken(token, request);
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			userService.deleteUser(user.getUser_id());
		}else {
			map.put("status", false);
		}
		map.put("msg", true);
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:修改用户信息，用图片路径进行传输，不使用上传的封面图片
	 * @param:user_id,nick_name,head_picture
	 * @return:
	 * @date 2019年3月25日 上午12:22:18*/
	@ResponseBody
	@RequestMapping("/updateUserByPath")
	public HashMap<String, Boolean> updateUserByPath(@RequestBody User user,HttpServletRequest request) {
		System.out.println("get:"+user.toString());
		
		HashMap<String, Boolean> map = new HashMap<>();
		
		String token = user.getToken();
		boolean checkToken = toolService.CheckToken(token, request);
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			userService.updateUser(user);
			map.put("msg", true);
		}else {
			map.put("status", false);
			map.put("msg", false);
		}
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:获取用户的全部信息
	 * @param:token,user_id
	 * @return:
	 * @date 2019年3月21日 下午7:59:17*/
	@ResponseBody
	@RequestMapping("/getUserAll")
	public HashMap<String, Object> getUserAll(@RequestBody User user,HttpServletRequest request){
		System.out.println("get："+user.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		String token = user.getToken();
		boolean checkToken = toolService.CheckToken(token, request);
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			User userInfoAll = userService.getUser(user.getUser_id());
			map.put("msg", userInfoAll);
		}else {
			map.put("status", false);
		}
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:输入用户id，返回用户的非私密信息(我的资料)
	 * @date 2019年3月14日 下午8:08:58*/
	@ResponseBody
	@RequestMapping("/getUserInfo")
	public HashMap<String, Object> getUserInfo(@RequestBody User user,HttpServletRequest request){
		System.out.println("get："+user.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		String token = user.getToken();
		boolean checkToken = toolService.CheckToken(token, request);
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			User userInfo = userService.getUserInfo(user.getUser_id());//获取用户信息
			map.put("msg", userInfo);
		}else {
			map.put("status", false);
		}
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:输入管理员权限，获取所有的用户资料
	 * @date 2019年3月14日 下午8:12:19*/
	@ResponseBody
	@RequestMapping("/listUser")
	public HashMap<String, Object> listUser(@RequestBody User user,HttpServletRequest request){
		System.out.println("get："+user.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		String token = user.getToken();
		boolean checkToken = toolService.CheckToken(token, request);
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			List<User> listUser = userService.listUser();
			map.put("msg", listUser);
		}else {
			map.put("status", false);
		}
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:根据管理员权限，返回分页查询的用户信息
	 * @param:page{int start,int count}
	 * @return:
	 * @date 2019年3月21日 下午8:04:46*/
	@ResponseBody
	@RequestMapping("/listUserByPage")
	public HashMap<String, Object> listUserByPage(@RequestBody StartCount page ,HttpServletRequest request){
		System.out.println("get："+page.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		String token = page.getToken();
		boolean checkToken = toolService.CheckToken(token, request);
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			Page temp = new Page();
			temp.setStart(page.getStart());
			temp.setCount(page.getCount());
			List<User> listUser = userService.listUserByPage(temp);
			map.put("msg", listUser);
		}else {
			map.put("status", false);
		}
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:输入账号名，返回true账号不存在，false账户已存在；注册和登录输入账号时可作为账号验证
	 * @date 2019年3月14日 下午8:37:33*/
	@ResponseBody
	@RequestMapping("/selectUserIfExist")
	public HashMap<String, Boolean> selectUserIfExist(@RequestBody User user){
		System.out.println("get："+user.toString());
		HashMap<String, Boolean> map = new HashMap<>();
		
//		String token = user.getToken();
//		boolean checkToken = toolService.CheckToken(token, request);
		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			User UserInfo = userService.selectUserByName(user.getName());
			if (UserInfo==null||UserInfo.toString().length()==0) {
				map.put("msg", true);//账户不存在
			}else {
				map.put("msg", false);//账户存在
			}
		}else {
			map.put("status", false);
		}
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:无参数，返回总用户数；可作为显示“你成为第几个注册用户”
	 * @date 2019年3月14日 下午8:46:52*/
	@ResponseBody
	@RequestMapping("/totalUser")
	public HashMap<String, Integer> totalUser() {
		int	totalUser = userService.totalUser();
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("msg", totalUser);
		
		return map;
	}
	
	/**@Description:输入From和To的用户Id，返回各自的name属性
	 * @param:
	 * @return:
	 * @date 2019年4月7日 上午10:55:54*/
	@ResponseBody
	@RequestMapping("/getUserNameLetterArea")
	public HashMap<String, Object> getUserNameLetterArea(@RequestBody FromTo fromTo,HttpServletRequest request) {
		System.out.println("get:"+fromTo.toString());
		HashMap<String, Object> map = new HashMap<>();
		
//		String token = fromTo.getToken();
//		boolean checkToken = toolService.CheckToken(token, request);
		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			String fromName = userService.getUserInfo(fromTo.getFromId()).getName();
			String toName = userService.getUserInfo(fromTo.getToId()).getName();
			FromTo fromToBack = new FromTo();
			fromToBack.setFromName(fromName);
			fromToBack.setToName(toName);
			map.put("msg", fromToBack);
		}else {
			map.put("status", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
}

