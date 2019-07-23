package com.lee.test;

import java.util.HashMap;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.controller.CommentController;
import com.lee.pojo.Comment;

/* @Description:测试评论控制类
 * @author: loved
 * @date: 2019年3月21日 下午5:13:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestCommentController {
	
	@Test
	public void addComment() {
		Comment comment = new Comment();
		CommentController controller = new CommentController();
		comment.setContent("content");
		comment.setFk_music_id(19);
		comment.setFk_user_id(10);
		comment.setStatus(0);
		HashMap<String, Boolean> addComment = controller.addComment(comment, null);
	}
}

