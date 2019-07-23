package com.lee.mapper;

import com.lee.pojo.QRCode;

/* @Description:
 * @author: loved
 * @date: 2019年3月31日 下午9:24:10
 */
public interface QRcodeMapper {
//	把二维码路径写入数据库
	public int addQRCode(QRCode qrCode);
	
//	查找二维码是否存在
	public QRCode selectQRcode(String content);
}

