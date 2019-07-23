package com.lee.mapper;
//歌曲和用户的收藏关系
import java.util.List;

import com.lee.pojo.Like;
import com.lee.pojo.SmsMusic;
import com.lee.pojo.User;

public interface LikeMapper {
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

	////	某一首歌的收藏总数
//	public int totalLikeByMusicId(UserMusicLike userMusicLike);//添加music_id参数
	
}
