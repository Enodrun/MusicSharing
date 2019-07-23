package com.lee.test;
/* @Description:为数据库插入批量数据以方便进行测试
 * @author: loved
 * @date: 2019年3月24日 下午5:22:56
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.pojo.Comment;
import com.lee.service.CommentService;
import com.lee.util.ShowRandom;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AddDataToTest {
	@Autowired
	private CommentService commentService;
	
	@Test
	public void addComment() {
		ShowRandom showRandom = new ShowRandom();
		for (int i = 0; i < 100; i++) {
			String content="感觉挺好的："+i;
			int fk_music_id=showRandom.mRandom(3, 26);
			int fk_user_id=showRandom.mRandom(24, 28);
			Comment comment = new Comment();
			comment.setContent(content);
			comment.setFk_music_id(fk_music_id);
			comment.setFk_user_id(fk_user_id);
			commentService.addComment(comment);
		}
	}
}

