package com.lee.service;

import com.lee.pojo.QRCode;

/* @Description:二维码的增加和查找操作
 * @author: loved
 * @date: 2019年3月31日 下午9:23:05
 */
public interface QRCodeService {
	
	public int addQRcode(QRCode qrcode);
	
	public QRCode selectQRcode(String content);
}

