package com.lee.service;

import java.util.List;

import com.lee.pojo.Lyric;

/* @Description:歌词操作业务类
 * @author: loved
 * @date: 2019年4月4日 下午8:41:30
 */
public interface LyricService {
//	增加歌词
	int add(Lyric lyric);
	
//	根据歌曲id和歌曲分类，查询歌词集合
	List<Lyric> list(Lyric lyric);//lyric_music_id和classify
}

