package com.lee.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.mapper.UserMapper;
import com.lee.pojo.User;
import com.lee.util.Page;

/* @Description:t_user操作测试
 * @author: loved
 * @date: 2019年3月10日 下午1:40:27
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUserMapper {
	@Autowired
	private UserMapper userMapper;
	
	/**@Description:用户注册
	 * @date 2019年3月10日 下午2:02:13*/
//	@Test
	public void AddUser() {
		User user = new User();
		user.setName("name");
		user.setPassword("888");
		user.setNick_name("李国超");
		user.setHead_picture("E:/作业/原型设计/guide.jpg");
		user.setMail("1061673303@qq.com");
		int addUser = userMapper.addUser(user);
		System.out.println("addUser："+addUser+user.toString());
	}
	
	/**@Description:根据账号查询用户
	 * @date 2019年3月10日 下午2:03:45*/
//	@Test
	public void SelectUserByName() {
		User user = userMapper.selectUserByName("name");
		if (user==null) {
			System.out.println("为空");
		} else {
			System.out.println(user.toString());
		}
	}
	
	/**@Description:账号登录
	 * @date 2019年3月10日 下午2:10:19*/
//	@Test
	public void SelectUserByNameAndPassword() {
		User user=new User();
		user.setName("name");
		user.setPassword("888");
		User pass = userMapper.selectUserByNameAndPassword(user);
		if (pass==null) {
			System.out.println("账号密码错误，登录失败");
		} else {
			System.out.println("登录成功："+pass.toString());
		}
	}
	
	/**@Description:删除账户
	 * @date 2019年3月10日 下午2:18:33*/
//	@Test
	public void deleteUser(){
		System.out.println("before delete:"+userMapper.totalUser());
		userMapper.deleteUser(9);
		System.out.println("after delete:"+userMapper.totalUser());
	}
	
	/**@Description:根据ID查询用户
	 * @date 2019年3月10日 下午2:22:35*/
//	@Test
	public void getUser() {
		User user = userMapper.getUser(10);
		System.out.println("getUser:"+user.toString());
	}
	
	/**@Description:修改用户信息
	 * @date 2019年3月10日 下午2:38:37*/
//	@Test
	public void updateUser() {
		User newUser=new User();
		newUser.setUser_id(10);
		newUser.setNick_name("一级棒");
		newUser.setHead_picture("E:/照片备份/temp/氢弹之父.JPEG");
		newUser.setMail("3113667108@qq.com");
		int updateUser = userMapper.updateUser(newUser);
		System.out.println("updateUser:"+updateUser);
		User selectUserByName = userMapper.selectUserByName("name");
		System.out.println("after update:"+selectUserByName);
	}
	
	/**@Description:查询所有用户数据
	 * @date 2019年3月10日 下午2:56:58*/
//	@Test
	public void listUser() {
		List<User> listUser = userMapper.listUser();
		System.out.println("listUser:"+listUser.toString());
	}
	
	/**@Description:用户分页查询
	 * @date 2019年3月10日 下午3:02:48*/
//	@Test
	public void listUserByPage() {
		Page page = new Page();
		page.setStart(0);//基0
		page.setCount(2);
		List<User> listUserByPage = userMapper.listUserByPage(page);
		System.out.println("listUserByPage:"+listUserByPage.toString());
	}

	/**@Description:查询用户的非敏感信息
	 * @date 2019年3月14日 下午6:40:39*/
//	@Test
	public void getUserInfo() {
		User userInfo = userMapper.getUserInfo(10);
		System.out.println(userInfo.toString());
	}
}

