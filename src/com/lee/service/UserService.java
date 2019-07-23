package com.lee.service;

import java.util.List;

import com.lee.pojo.User;
import com.lee.util.Page;

/* @Description:用户表操作
 * @author: loved
 * @date: 2019年3月11日 下午1:47:02
 */
public interface UserService {
//	用户注册
	public int addUser(User user);//新增用户
	public User selectUserByName(String name);

//	用户登录
	public User selectUserByNameAndPassword(User user);
	
	public void deleteUser(int id);//删除用户
	public User getUser(int id);//获取用户对象（全部信息）
	public User getUserInfo(int id);//获取用户对象的非敏感信息
	public int updateUser(User user);//更新一个用户
	public List<User> listUser();//返回所有用户
	public List<User> listUserByPage(Page page);//分页返回用户
	public int totalUser();//返回总用户数
}

