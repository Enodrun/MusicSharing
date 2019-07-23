package com.lee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.mapper.LetterMapper;
import com.lee.pojo.Letter;
import com.lee.pojo.User;
import com.lee.service.LetterService;

/* @Description:私信表操作实现
 * @author: loved
 * @date: 2019年3月11日 下午2:28:22
 */
@Service
public class LetterServiceImpl implements LetterService {

	/* (non-Javadoc)
	 * @see com.lee.service.LetterService#addLetter(com.lee.pojo.Letter)
	 */
	@Autowired
	private LetterMapper LetterMapper;
	
	@Override
	public int addLetter(Letter letter) {
		// TODO Auto-generated method stub
		return LetterMapper.addLetter(letter);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.LetterService#selectLetterBySend(com.lee.pojo.User)
	 */
	@Override
	public List<Letter> selectLetterBySend(User userSend) {
		// TODO Auto-generated method stub
		return LetterMapper.selectLetterBySend(userSend);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.LetterService#selectLetterByReceive(com.lee.pojo.User)
	 */
	@Override
	public List<Letter> selectLetterByReceive(User userReceive) {
		// TODO Auto-generated method stub
		return LetterMapper.selectLetterByReceive(userReceive);
	}

}

