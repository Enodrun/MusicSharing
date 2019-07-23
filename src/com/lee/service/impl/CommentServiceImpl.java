package com.lee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.mapper.CommentMapper;
import com.lee.pojo.Comment;
import com.lee.service.CommentService;

/* @Description:评论表操作实现
 * @author: loved
 * @date: 2019年3月11日 下午1:50:21
 */
@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentMapper commentMapper;
	/* (non-Javadoc)
	 * @see com.lee.service.CommentService#addComment(com.lee.pojo.Comment)
	 */
	@Override
	public int addComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentMapper.addComment(comment);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.CommentService#listCommentByMusic(int)
	 */
	@Override
	public List<Comment> listCommentByMusic(int music_id) {
		// TODO Auto-generated method stub
		return commentMapper.listCommentByMusic(music_id);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.CommentService#listCommentByStatus(int)
	 */
	@Override
	public List<Comment> listCommentByStatus(int status) {
		// TODO Auto-generated method stub
		return commentMapper.listCommentByStatus(status);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.CommentService#deleteCommentInOne(int)
	 */
	@Override
	public void deleteCommentInOne(int comment_id) {
		// TODO Auto-generated method stub
		commentMapper.deleteCommentInOne(comment_id);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.CommentService#deleteCommentInUser(int)
	 */
	@Override
	public void deleteCommentInUser(int user_id) {
		// TODO Auto-generated method stub
		commentMapper.deleteCommentInUser(user_id);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.CommentService#updateCommentStatus(com.lee.pojo.Comment)
	 */
	@Override
	public int updateCommentStatus(Comment comment) {
		// TODO Auto-generated method stub
		return commentMapper.updateCommentStatus(comment);
	}

}

