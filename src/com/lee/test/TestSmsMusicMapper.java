package com.lee.test;
/* @Description:短信点播
 * @author: loved
 * @date: 2019年3月10日 下午7:22:09
 */

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.mapper.SmsMusicMapper;
import com.lee.pojo.SmsMusic;
import com.lee.pojo.User;
import com.lee.service.SmsMusicService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSmsMusicMapper {
	@Autowired
	private SmsMusicMapper smsMusicMapper;
	@Autowired
	private SmsMusicService smsMusicService;
	
	/**@Description:添加短信点播
	 * @date 2019年3月10日 下午7:52:57*/
//	@Test
	public void addSmsMusic() {
		SmsMusic smsMusic = new SmsMusic();
		smsMusic.setFk_user_id(9);
		smsMusic.setTel("18320422412");
		smsMusic.setCommand("生日快乐");
//		smsMusic.setLetter(letter);//回信
		smsMusic.setTitle("《起风了》");
		smsMusic.setSend("发送人：A先生");
		smsMusic.setReceive("收件人：某人");
		smsMusic.setReceive_tel("13113059440");
		smsMusic.setMusic_path("C:/Users/loved/Pictures/QQ浏览器截图/QQ浏览器截图20190226230736.mp3");
		smsMusic.setPicture_path("C:/Users/loved/Pictures/QQ浏览器截图/QQ浏览器截图20190226230736.png");
		smsMusic.setWish("祝你生日快乐");
		smsMusic.setWords("这首歌是送给你的，非常好听哦");
		int addSmsMusic = smsMusicMapper.addSmsMusic(smsMusic);
		System.out.println(addSmsMusic);
	}
	
	/**@Description:返回个人点播列表
	 * @date 2019年3月10日 下午8:08:03*/
//	@Test
	public void listSmsMusic() {
		User user = new User();
		user.setUser_id(9);
		List<SmsMusic> listSmsMusic = smsMusicMapper.listSmsMusic(user);
		System.out.println(listSmsMusic.toString());
	}
	
	/**@Description:输入电话和口令进行观看
	 * @date 2019年3月10日 下午8:15:00*/
//	@Test
	public void selectSmsMusicByTelAndCommand() {
		SmsMusic smsMusic = new SmsMusic();
		smsMusic.setSms_id(1);//短信id
		smsMusic.setCommand("生日快乐");
		smsMusic.setReceive_tel("13113059440");
		SmsMusic selectSmsMusicByTelAndCommand = smsMusicMapper.selectSmsMusicByTelAndCommand(smsMusic);
		System.out.println(selectSmsMusicByTelAndCommand.toString());
	}
	
	@Test
	public void selectSmsMusicBySmsId() {
		SmsMusic smsMusic = new SmsMusic();
		smsMusic.setSms_id(6);//短信id
		SmsMusic selectSmsMusicBySmsId = smsMusicService.selectSmsMusicBySmsId(smsMusic);
		System.out.println(selectSmsMusicBySmsId.toString());
	}
	
	
	/**@Description:添加回信
	 * @date 2019年3月10日 下午8:02:53*/
//	@Test
	public void updateSmsMusicByLetter() {
		SmsMusic smsMusic = new SmsMusic();
		smsMusic.setLetter("我听到了，谢谢你！");
		smsMusic.setSms_id(3);
		int updateSmsMusicByLetter = smsMusicMapper.updateSmsMusicByLetter(smsMusic);
		System.out.println(updateSmsMusicByLetter);
	}
}

