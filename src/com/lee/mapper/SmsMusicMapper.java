package com.lee.mapper;
//点播一首音乐给别人，鲸鱼点播；
import java.util.List;

import com.lee.pojo.SmsMusic;
import com.lee.pojo.User;

public interface SmsMusicMapper {
//	上传音乐和填写信息
	public int addSmsMusic(SmsMusic smsMusic);
	
//	个人音乐列表我的点播,回信查询
	public List<SmsMusic> listSmsMusic(User user);
	
//	权限手机+观看密码，查询歌曲(方法繁琐，暂时不用)
	public SmsMusic selectSmsMusicByTelAndCommand(SmsMusic smsMusic);//把sms_id,receive_tel和command作为参数加入

//	查询sms_id和command匹配的歌曲记录
	public SmsMusic selectSmsMusicBySmsIdAndCommand(SmsMusic idAndCommand);//把sms_id和command作为参数加入
	
//	查询sms_id歌曲记录
	public SmsMusic selectSmsMusicBySmsId(SmsMusic id);//把sms_id作为参数加入
	
//	收听人回信录入
	public int updateSmsMusicByLetter(SmsMusic letterAndSmsId);//把letter和sms_id作为参数加入

}
