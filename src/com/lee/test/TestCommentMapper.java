package com.lee.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.mapper.CommentMapper;
import com.lee.pojo.Comment;
import com.lee.service.CommentService;

/* @Description:评论测试
 * @author: loved
 * @date: 2019年3月10日 下午4:13:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestCommentMapper {
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private CommentService commentService;
	/**@Description:新增一条评论
	 * @date 2019年3月10日 下午6:36:39*/
//	@Test
	public void addComment() {
		Comment comment = new Comment();
		comment.setFk_user_id(10);
		comment.setFk_music_id(3);
		comment.setContent("这音乐很好听");
		comment.setStatus(0);
//		int addComment = commentMapper.addComment(comment);
		int addComment = commentService.addComment(comment);
		System.out.println(addComment);
	}
	
	/**@Description:返回评论列表
	 * @date 2019年3月10日 下午6:39:17*/
//	@Test
	public void listCommentByMusic() {
		List<Comment> listCommentByMusic = commentMapper.listCommentByMusic(3);
		System.out.println(listCommentByMusic.toString());
	}
	
	/**@Description:返回状态异常评论
	 * @date 2019年3月10日 下午6:42:19*/
//	@Test
	public void listCommentByStatus() {
		List<Comment> listCommentByStatus = commentMapper.listCommentByStatus(0);
		System.out.println(listCommentByStatus);
	}
	
	/**@Description:删除一条评论
	 * @date 2019年3月10日 下午6:44:44*/
//	@Test
	public void deleteCommentInOne() {
		commentMapper.deleteCommentInOne(3);
	}
	
	/**@Description:删除某人所有评论
	 * @date 2019年3月10日 下午6:46:27*/
//	@Test
	public void deleteCommentInUser() {
		commentMapper.deleteCommentInUser(10);
	}
	
	/**@Description:修改评论状态
	 * @date 2019年3月10日 下午6:59:03*/
//	@Test
	public void updateCommentStatus() {
		Comment comment = new Comment();
		comment.setComment_id(15);
		comment.setStatus(1);
		int updateCommentStatus = commentMapper.updateCommentStatus(comment);
		System.out.println(updateCommentStatus);
	}
}

