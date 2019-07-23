package com.lee.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lee.pojo.User;
import com.lee.service.FileService;
import com.lee.service.UserService;

/* @Description:处理与图片、音乐等文件格式上传的控制类
 * @author: loved
 * @date: 2019年3月20日 下午10:59:27
 */
@Controller
@RequestMapping("")
public class FileController {
	@Autowired
	private FileService fileService;
	@Autowired
	private UserService userService;
	
	/**@throws Exception 
	 * @throws IllegalStateException 
	 * @Description:输入user_id和其他要修改的信息，返回修改后的个人信息
	 * @date 2019年3月14日 下午8:54:37*/
	@ResponseBody
	@RequestMapping("/changeUser")
	public String updateUser(User user,HttpServletRequest request) throws IllegalStateException, Exception {
		System.out.println("接收到："+user.toString());
		
		String token = user.getToken();
		Object compare = request.getSession().getAttribute("token");
		String reString=null;
		
		if (token==null) {
			reString="请求错误，请重新登录";//token为空
		}else {
			if (compare.equals(token)) {
				System.out.println("compare.equals(token)："+compare.equals(token));
				System.out.println(("compare==token:"+compare==token));
				
				File savePicture = fileService.savePicture(user.getUser_id());//待转换的图片对象
				MultipartFile fontPicture=user.getHead_file();//前端的图片对象
				fontPicture.transferTo(savePicture);//转换成本地创建的对象
				String path="vipFiles/"+user.getUser_id()+"/head/"+savePicture.getName();//待存数据库的相对路径
				user.setHead_picture(path);
				System.out.println("path:"+path+"savePicture:"+savePicture);
				
				int updateUser = userService.updateUser(user);//更新到数据库中
				System.out.println("update success");
				if (updateUser==1) {
					reString="更新成功";//更新成功
				}else {
					reString="更新失败，请稍后再试";//更新失败
				}
			}
		}
		
		return reString;
	}
}

