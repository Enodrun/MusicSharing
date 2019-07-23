package com.lee.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.mapper.LikeMapper;
import com.lee.pojo.Like;

/* @Description:歌曲收藏列表测试
 * @author: loved
 * @date: 2019年3月10日 下午8:33:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUserMusicLikeMapper {
	@Autowired
	private LikeMapper likeMapper;
	
	/**@Description:添加收藏
	 * @date 2019年3月10日 下午8:43:50*/
//	@Test
	public void addLike() {
		Like userMusicLike = new Like();
		userMusicLike.setFk_user_id(10);
		userMusicLike.setFk_music_id(5);
		int addLike = likeMapper.addLike(userMusicLike);
		System.out.println(addLike);
	}
	
	/**@Description:查找个人收藏歌曲
	 * @date 2019年3月10日 下午8:58:28*/
//	@Test
	public void listUserMusicLikeByUser() {
		Like userMusicLike = new Like();
		userMusicLike.setFk_user_id(10);
		List<Like> listLikeByUser = likeMapper.listLikeByUser(userMusicLike);
		System.out.println(listLikeByUser.toString());
	}
	
	/**@Description:查找歌曲收藏的人
	 * @date 2019年3月10日 下午9:24:13*/
//	@Test
	public void listUserMusicLikeByMusic() {
		Like userMusicLike = new Like();
		userMusicLike.setFk_music_id(4);
		List<Like> listLikeByUser = likeMapper.listLikeByMusic(userMusicLike);
		System.out.println(listLikeByUser.toString());
	}
	
}

