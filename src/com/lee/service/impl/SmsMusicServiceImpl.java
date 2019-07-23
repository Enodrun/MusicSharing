package com.lee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.mapper.SmsMusicMapper;
import com.lee.pojo.SmsMusic;
import com.lee.pojo.User;
import com.lee.service.SmsMusicService;

/* @Description:短信点播操作实现
 * @author: loved
 * @date: 2019年3月11日 下午2:45:45
 */
@Service
public class SmsMusicServiceImpl implements SmsMusicService {
	

	@Autowired
	private SmsMusicMapper smsMusicMapper;
	
	@Override
	public SmsMusic selectSmsMusicBySmsId(SmsMusic id) {
		// TODO Auto-generated method stub
		return smsMusicMapper.selectSmsMusicBySmsId(id);
	}
	/* (non-Javadoc)
	 * @see com.lee.service.SmsMusicService#addSmsMusic(com.lee.pojo.SmsMusic)
	 */
	@Override
	public int addSmsMusic(SmsMusic smsMusic) {
		// TODO Auto-generated method stub
		return smsMusicMapper.addSmsMusic(smsMusic);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.SmsMusicService#listSmsMusic(com.lee.pojo.User)
	 */
	@Override
	public List<SmsMusic> listSmsMusic(User user) {
		// TODO Auto-generated method stub
		return smsMusicMapper.listSmsMusic(user);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.SmsMusicService#selectSmsMusicByTelAndCommand(com.lee.pojo.SmsMusic)
	 */
	@Override
	public SmsMusic selectSmsMusicByTelAndCommand(SmsMusic sms_id_receive_tel_command) {
		// TODO Auto-generated method stub
		return smsMusicMapper.selectSmsMusicByTelAndCommand(sms_id_receive_tel_command);//把sms_id,receive_tel和command作为参数加入
	}

	@Override
	public SmsMusic selectSmsMusicBySmsIdAndCommand(SmsMusic id_command) {
		// TODO Auto-generated method stub
		return smsMusicMapper.selectSmsMusicBySmsIdAndCommand(id_command);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.SmsMusicService#updateSmsMusicByLetter(com.lee.pojo.SmsMusic)
	 */
	@Override
	public int updateSmsMusicByLetter(SmsMusic letterAndSmsId) {
		// TODO Auto-generated method stub
		return smsMusicMapper.updateSmsMusicByLetter(letterAndSmsId);
	}

}

