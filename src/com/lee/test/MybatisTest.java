package com.lee.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.mapper.CategoryMapper;
import com.lee.mapper.UserMapper;
import com.lee.pojo.Category;
import com.lee.pojo.User;
import com.lee.util.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private UserMapper userMapper;

//	@Test
	public void testAdd() {
		Category category = new Category();
		category.setName("new Category");
		categoryMapper.add(category);
		System.out.println(category.getName());
	}
	
//	@Test
	public void testTotal() {
		int total = categoryMapper.total();
		System.out.println(total);
	}

//	@Test
	public void testList() {
		Page p = new Page();
		p.setStart(2);
		p.setCount(3);
		List<Category> cs=categoryMapper.list(p);
		for (Category c : cs) {
			System.out.println(c.getName());
		}
	}
//用户注册
//	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("testUser");
		user.setPassword("testUser");
		userMapper.addUser(user);
		System.out.println(user.getName()+"	"+user.getPassword());
	}
//	@Test
	public void testSelectUserByName() {
		User user = userMapper.selectUserByName("testUser");
		if (user==null) {
			System.out.println("为空");
		} else {
			System.out.println(user.toString());
		}
	}
	@Test
	public void testSelectUserByNameAndPassword() {
		User user=new User();
		user.setName("1");
		user.setPassword("1");
		User user2 = userMapper.selectUserByNameAndPassword(user);
		System.out.println(user2.toString());
	}
}
