package com.lee.test;

import java.util.List;

import javax.sql.StatementEventListener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.mapper.MusicMapper;
import com.lee.pojo.Music;
import com.lee.pojo.User;
import com.lee.util.Page;

/* @Description:
 * @author: loved
 * @date: 2019年3月10日 下午4:20:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMusicMapper {
	@Autowired
	private MusicMapper musicMapper;
	
	/**@Description:
	 * @date 2019年3月10日 下午4:26:56*/
//	@Test
	public void addMusic() {
		Music music = new Music();
		music.setName("you are beautiful");
		music.setFile("C:Users/loved/Pictures/Screenshots/屏幕截图(1).mp3");
		music.setCover("C:Users/loved/Pictures/Screenshots/屏幕截图(1).png");
		music.setFk_user_id(10);
		music.setLikes(0);
		int addMusic = musicMapper.addMusic(music);
		System.out.println("addMusic:"+addMusic);
	}
	
	/**@Description:分页查询音乐列表,最新的音乐先被展示
	 * @date 2019年3月10日 下午4:34:45*/
//	@Test
	public void listMusicByPage() {
		Page page = new Page();
		page.setStart(0);//第几条开始，从最后一条降序排列
		page.setCount(3);//每页数量
		List<Music> listMusicByPage = musicMapper.listMusicByPage(page);
		System.out.println(listMusicByPage.toString());
	}
	
	/**@Description:用户上传音乐列表
	 * @date 2019年3月10日 下午4:43:57*/
//	@Test
	public void listMusicByUser() {
		User user = new User();
		user.setUser_id(10);
		List<Music> listMusicByUser = musicMapper.listMusicByUser(user);
		System.out.println(listMusicByUser.toString());
	}
	
	/**@Description:删除音乐
	 * @date 2019年3月10日 下午4:46:15*/
//	@Test
	public void deleteMusicById() {
		musicMapper.deleteMusicById(2);
	}
	
	/**@Description:收藏数+1
	 * @date 2019年3月10日 下午5:15:23*/
//	@Test
	public void updateMusicInLikes() {
		Music music = new Music();
		music.setMusic_id(3);
		int likes = musicMapper.updateMusicInLikes(music);
		System.out.println(likes);
		System.out.println(music.toString());
	}
	
	/**@Description:收藏的likes总数
	 * @date 2019年3月10日 下午5:28:11*/
//	@Test
	public void selectLikesByMusicId() {
		Music music = new Music();
		music.setMusic_id(3);
		int likes = musicMapper.selectLikesByMusicId(music);
		System.out.println(likes);
	}
	
	/**@Description:音乐总数
	 * @date 2019年3月14日 下午12:01:13*/
//	@Test
	public void totalMusic() {
		int totalMusic = musicMapper.totalMusic();
		System.out.println("total:"+totalMusic);
	}
	
//	@Test
	public void listMusicById() {
		Music selectMusicById = musicMapper.selectMusicById(10);
		System.out.println(selectMusicById.toString());
	}
}

