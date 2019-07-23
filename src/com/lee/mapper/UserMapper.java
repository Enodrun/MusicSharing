package com.lee.mapper;

import java.util.List;

import com.lee.pojo.User;
import com.lee.util.Page;

public interface UserMapper {
//	用户注册
	public int addUser(User user);//新增用户
	public User selectUserByName(String name);

//	用户登录
	public User selectUserByNameAndPassword(User user);
	
	public void deleteUser(int id);//删除用户
	public User getUser(int id);//获取用户对象全部信息
	public User getUserInfo(int id);//获取用户的普通信息（不含密码）
	public int updateUser(User user);//更新一个用户
	public List<User> listUser();//返回所有用户
	public List<User> listUserByPage(Page page);//分页返回用户
	public int totalUser();//返回总用户数
}	
