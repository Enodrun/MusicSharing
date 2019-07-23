package com.lee.service;

import javax.servlet.http.HttpServletRequest;

/* @Description:需要重复调用的一些逻辑工具
 * @author: loved
 * @date: 2019年3月21日 下午2:48:19
 */
public interface ToolsService {
	/**@Description:输入token和HttpServletRequest参数，返回1：验证成功；0：验证失败（token！=null）
	 * @date 2019年3月21日 下午2:57:30*/
	boolean CheckToken(String token, HttpServletRequest request);
	
	/**@Description:获取最新的一条点播歌曲记录的sms_id,方便进行url的字符串拼接
	 * @param:fk_user_id(smsMusic类)
	 * @return:该用户的最新一条sms_id
	 * @date 2019年3月30日 下午8:44:08*/
	int getNewSmsId(int fk_user_id);
	
	/**@Description:根据完整的网页地址获取当前的主机地址
	 * @param:页面的href
	 * @return:主机地址:http://localhost:8080/MusicSharing/static/
	 * @date 2019年3月30日 下午9:24:50*/
	String getHostName(String href);
	
	/**@Description:截取url后面的参数
	 * @param:url
	 * @return:sms_id
	 * @date 2019年3月31日 上午11:35:32*/
	String getSms_id(String href);
	
	/**@Description:实现网址url转换成二维码，保存到文件夹并返回路径字串
	 * @param:url
	 * @return:二维码图片的路径，path
	 * @date 2019年3月31日 下午9:08:11*/
	String getQRCode(String url);
}
