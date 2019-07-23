package com.lee.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.mapper.LetterMapper;
import com.lee.pojo.Letter;
import com.lee.pojo.User;

/* @Description:私信功能
 * @author: loved
 * @date: 2019年3月10日 下午6:59:53
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestLetterMapper {
	@Autowired
	private LetterMapper letterMapper;
	
	/**@Description:增加一条私信
	 * @date 2019年3月10日 下午7:08:05*/
//	@Test
	public void addLetter() {
		Letter letter = new Letter();
		letter.setFk_user_send(10);
		letter.setFk_user_receive(9);
		letter.setContent("好啊，走起");
		int addLetter = letterMapper.addLetter(letter);
		System.out.println(addLetter);
	}
	
	/**@Description:已发送
	 * @date 2019年3月10日 下午7:14:18*/
//	@Test
	public void selectLetterBySend() {
		User send = new User();
		send.setUser_id(9);
		List<Letter> letters = letterMapper.selectLetterBySend(send);
		System.out.println(letters.toString());
	}
	
	/**@Description:已发送
	 * @date 2019年3月10日 下午7:16:55*/
//	@Test
	public void selectLetterByReceive() {
		User receive = new User();
		receive.setUser_id(9);
		List<Letter> letters = letterMapper.selectLetterByReceive(receive);
		System.out.println(letters.toString());
	}
}

