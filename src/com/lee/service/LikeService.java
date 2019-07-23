package com.lee.service;

import java.util.List;

import com.lee.pojo.Like;

/* @Description:收藏表操作
 * @author: loved
 * @date: 2019年3月11日 下午1:44:18
 */
public interface LikeService {
//	添加收藏
	public int addLike(Like like);
	
//	删除收藏
	public int disLike(Like like);
	
//	某个人的收藏歌曲列表
	public List<Like> listLikeByUser(Like like);//添加user_id参数
	
//	某首音乐的收藏用户列表id
	public List<Like> listLikeByMusic(Like like);//添加music_id参数

//	根据用户id和音乐id查看是否已有收藏记录
	public Like confirmLike(Like fk_user_idAndfk_music_id);
}

