package com.lee.service;

import java.util.List;

import com.lee.pojo.SmsMusic;
import com.lee.pojo.User;

/* @Description:短信点播表操作
 * @author: loved
 * @date: 2019年3月11日 下午1:46:14
 */
public interface SmsMusicService {
//	上传音乐和填写信息
	public int addSmsMusic(SmsMusic smsMusic);
	
//	个人音乐列表我的点播,回信查询
	public List<SmsMusic> listSmsMusic(User user);
	
//	权限手机+观看密码，查询歌曲
	public SmsMusic selectSmsMusicByTelAndCommand(SmsMusic smsMusic);//把sms_id,receive_tel和command作为参数加入
	
//	输入sms_id和command，查询相关音乐
	public SmsMusic selectSmsMusicBySmsIdAndCommand(SmsMusic id_command);
	
//	输入sms_id查询相关音乐
	public SmsMusic selectSmsMusicBySmsId(SmsMusic id);//把sms_id作为参数加入

//	收听人回信录入
	public int updateSmsMusicByLetter(SmsMusic letterAndSmsId);//把letter和sms_id作为参数加入
}

