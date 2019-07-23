package com.lee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.mapper.MusicMapper;
import com.lee.pojo.Music;
import com.lee.pojo.User;
import com.lee.service.MusicService;
import com.lee.util.Page;

/* @Description:音乐信息表操作实现
 * @author: loved
 * @date: 2019年3月11日 下午2:42:05
 */
@Service
public class MusicServiceImpl implements MusicService {
	@Autowired
	private MusicMapper musicMapper;
	/* (non-Javadoc)
	 * @see com.lee.service.MusicService#addMusic(com.lee.pojo.Music)
	 */
	@Override
	public int addMusic(Music music) {
		// TODO Auto-generated method stub
		return musicMapper.addMusic(music);
	}

	@Override
	public Music selectMusicById(int id) {
		// TODO Auto-generated method stub
		return musicMapper.selectMusicById(id);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.MusicService#listMusicByPage(com.lee.util.Page)
	 */
	@Override
	public List<Music> listMusicByPage(Page page) {
		// TODO Auto-generated method stub
		return musicMapper.listMusicByPage(page);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.MusicService#listMusicByUser(com.lee.pojo.User)
	 */
	@Override
	public List<Music> listMusicByUser(User user) {
		// TODO Auto-generated method stub
		return musicMapper.listMusicByUser(user);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.MusicService#deleteMusicById(int)
	 */
	@Override
	public void deleteMusicById(int music_id) {
		// TODO Auto-generated method stub
		musicMapper.deleteMusicById(music_id);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.MusicService#updateMusicInLikes(com.lee.pojo.Music)
	 */
	@Override
	public int updateMusicInLikes(Music music) {
		// TODO Auto-generated method stub
		return musicMapper.updateMusicInLikes(music);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.MusicService#selectLikesByMusicId(com.lee.pojo.Music)
	 */
	@Override
	public int selectLikesByMusicId(Music music) {
		// TODO Auto-generated method stub
		return musicMapper.selectLikesByMusicId(music);
	}
	
	@Override
	public int totalMusic() {
		return musicMapper.totalMusic();
	}
}

