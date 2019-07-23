package com.lee.mapper;

import java.util.List;

import com.lee.pojo.Lyric;

/* @Description:歌词数据口操作接口
 * @author: loved
 * @date: 2019年4月4日 下午8:30:06
 */
public interface LyricMapper {

//	增加歌词
	public int addLyric(Lyric lyric);
	
//	根据歌曲id和歌曲分类，查询歌词集合
	public List<Lyric> listLyric(Lyric lyric);//lyric_music_id和classify
}

