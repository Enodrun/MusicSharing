package com.lee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.mapper.LyricMapper;
import com.lee.pojo.Lyric;
import com.lee.service.LyricService;

/* @Description:
 * @author: loved
 * @date: 2019年4月4日 下午8:43:05
 */
@Service
public class LyricServiceImpl implements LyricService {
	@Autowired
	private LyricMapper lyricMapper;
	
	/* (non-Javadoc)
	 * @see com.lee.service.LyricService#add(com.lee.pojo.Lyric)
	 */
	@Override
	public int add(Lyric lyric) {
		// TODO Auto-generated method stub
		return lyricMapper.addLyric(lyric);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.LyricService#list(com.lee.pojo.Lyric)
	 */
	@Override
	public List<Lyric> list(Lyric lyric) {
		// TODO Auto-generated method stub
		return lyricMapper.listLyric(lyric);
	}

}

