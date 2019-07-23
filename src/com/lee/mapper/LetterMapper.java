package com.lee.mapper;
//私信功能
import java.util.List;

import com.lee.pojo.Letter;
import com.lee.pojo.User;
import com.lee.util.Page;

public interface LetterMapper {
//	写好私信发送成功，即数据库新增成功
	public int addLetter(Letter letter);
//	查看私信列表全部信息
	public List<Letter> selectLetterBySend(User userSend);//发送的
	public List<Letter> selectLetterByReceive(User userReceive);//接收的
}
