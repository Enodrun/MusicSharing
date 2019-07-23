package com.lee.mapper;

import java.util.List;

import com.lee.pojo.Comment;
import com.lee.pojo.User;
import com.lee.util.Page;

public interface CommentMapper {
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
	
	
//	public Comment selectUserByName(String name);

//	用户登录
//	public User selectUserByNameAndPassword(User user);
//	
//	public void deleteUser(int id);//删除用户
//	public User getUser(int id);//获取用户对象
//	public int updateUser(User user);//更新一个用户
//	public List<User> listUser();//返回所有用户
//	public List<User> listUserByPage(Page page);//分页返回用户
//	public int totalUser();//返回总用户数
}
