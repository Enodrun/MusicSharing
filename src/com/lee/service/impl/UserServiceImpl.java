package com.lee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.mapper.UserMapper;
import com.lee.pojo.User;
import com.lee.service.UserService;
import com.lee.util.Page;

/* @Description:用户表操作
 * @author: loved
 * @date: 2019年3月11日 下午2:49:48
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	/* (non-Javadoc)
	 * @see com.lee.service.UserService#addUser(com.lee.pojo.User)
	 */
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.addUser(user);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.UserService#selectUserByName(java.lang.String)
	 */
	@Override
	public User selectUserByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByName(name);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.UserService#selectUserByNameAndPassword(com.lee.pojo.User)
	 */
	@Override
	public User selectUserByNameAndPassword(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByNameAndPassword(user);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.UserService#deleteUser(int)
	 */
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(id);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.UserService#getUser(int)
	 */
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userMapper.getUser(id);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.UserService#updateUser(com.lee.pojo.User)
	 */
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.UserService#listUser()
	 */
	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return userMapper.listUser();
	}

	/* (non-Javadoc)
	 * @see com.lee.service.UserService#listUserByPage(com.lee.util.Page)
	 */
	@Override
	public List<User> listUserByPage(Page page) {
		// TODO Auto-generated method stub
		return userMapper.listUserByPage(page);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.UserService#totalUser()
	 */
	@Override
	public int totalUser() {
		// TODO Auto-generated method stub
		return userMapper.totalUser();
	}

	@Override
	public User getUserInfo(int id) {
		// TODO Auto-generated method stub
		return userMapper.getUserInfo(id);
	}

}

