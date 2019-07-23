package com.lee.service;

import java.util.List;

import com.lee.pojo.Music;
import com.lee.pojo.User;
import com.lee.util.Page;

/* @Description:音乐信息表操作
 * @author: loved
 * @date: 2019年3月11日 下午1:45:12
 */
public interface MusicService {
//	音乐上传
	public int addMusic(Music music);
	
//	网站首页歌曲列表
	public List<Music> listMusicByPage(Page page);
	
//	根据歌曲id返回歌曲的信息
	public Music selectMusicById(int id);
	
//	个人列表根据上传者返回上传音乐列表
	public List<Music> listMusicByUser(User user);
	
//	删除音乐
	public void deleteMusicById(int music_id);
	
//	修该likes的数值+1
	public int updateMusicInLikes(Music music);//输入music_id
	
//	返回某首音乐的likes
	public int selectLikesByMusicId(Music music);//输入music_id
	
//	返回音乐总条数
	public int totalMusic();
}

