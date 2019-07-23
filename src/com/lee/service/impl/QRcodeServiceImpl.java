package com.lee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.mapper.QRcodeMapper;
import com.lee.pojo.QRCode;
import com.lee.service.QRCodeService;

/* @Description:
 * @author: loved
 * @date: 2019年3月31日 下午9:39:27
 */
@Service
public class QRcodeServiceImpl implements QRCodeService {
	@Autowired
	private QRcodeMapper qrmapper;
	/* (non-Javadoc)
	 * @see com.lee.service.QRCodeService#addQRcode(com.lee.pojo.QRCode)
	 */
	@Override
	public int addQRcode(QRCode qrcode) {//增加操作
		// TODO Auto-generated method stub		
		return qrmapper.addQRCode(qrcode);
	}

	/* (non-Javadoc)
	 * @see com.lee.service.QRCodeService#selectQRcode(java.lang.String)
	 */
	@Override
	public QRCode selectQRcode(String content) {
		// TODO Auto-generated method stub
		return qrmapper.selectQRcode(content);
	}

}

