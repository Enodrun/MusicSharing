package com.lee.test;
/* @Description:
 * @author: loved
 * @date: 2019年3月14日 下午1:21:50
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.service.MusicService;
import com.lee.util.Page;
import com.lee.util.RandomPage;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestRandomPage {
	@Autowired
	private MusicService musicservie;
	/**@Description:测试分页
	 * @date 2019年3月14日 下午1:22:47*/
//	@Test
	public void TestRandomPage() {
		RandomPage randomPage = new RandomPage();
		for (int i = 0; i < 10; i++) {
			Page page = randomPage.getPage(musicservie.totalMusic(),5, 10, 20, true);
			System.out.println("第"+i+"次"+page.toString());
		}
	}

}

