package com.lee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.mapper.LikeMapper;
import com.lee.pojo.Like;
import com.lee.service.LikeService;

/* @Description:收藏表操作实现
 * @author: loved
 * @date: 2019年3月11日 下午2:30:25
 */
@Service
public class LikeServiceImpl implements LikeService {
	@Override
	public int disLike(Like like) {
		// TODO Auto-generated method stub
		return likeMapper.disLike(like);
	}

	@Override
	public Like confirmLike(Like fk_user_idAndfk_music_id) {
		// TODO Auto-generated method stub
		return likeMapper.confirmLike(fk_user_idAndfk_music_id);
	}

	@Autowired
	private LikeMapper likeMapper;
	
	/* (non-Javadoc)
	 * @see com.lee.service.LikeService#addLike(com.lee.pojo.Like)
	 */
	@Override
	public int addLike(Like like) {
		// TODO Auto-generated method stub
		return likeMapper.addLike(like);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.LikeService#listLikeByUser(com.lee.pojo.Like)
	 */
	@Override
	public List<Like> listLikeByUser(Like like) {
		// TODO Auto-generated method stub
		return likeMapper.listLikeByUser(like);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.LikeService#listLikeByMusic(com.lee.pojo.Like)
	 */
	@Override
	public List<Like> listLikeByMusic(Like like) {
		// TODO Auto-generated method stub
		return likeMapper.listLikeByMusic(like);
	}

}

