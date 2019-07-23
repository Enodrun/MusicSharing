package com.lee.service;

import java.util.List;

import com.lee.pojo.Comment;

/* @Description:评论表操作
 * @author: loved
 * @date: 2019年3月11日 下午1:36:01
 */
public interface CommentService {
//	新增一条评论
	public int addComment(Comment comment);
	
//  根据歌曲id查询评论列表	
	public List<Comment> listCommentByMusic(int music_id);
	
//	根据举报状态返回评论对象,0为正常,1为被举报
	public List<Comment> listCommentByStatus(int status);
	
//	删除单条评论
	public void deleteCommentInOne(int comment_id);
	
//	删除某个用户的评论
	public void deleteCommentInUser(int user_id);
	
//	修改某个评论的状态，0正常，1举报
	public int updateCommentStatus(Comment comment);
}

