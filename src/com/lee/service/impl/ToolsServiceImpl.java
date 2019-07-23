package com.lee.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.mapper.QRcodeMapper;
import com.lee.mapper.SmsMusicMapper;
import com.lee.pojo.QRCode;
import com.lee.pojo.SmsMusic;
import com.lee.pojo.User;
import com.lee.service.SmsMusicService;
import com.lee.service.ToolsService;
import com.lee.util.QRCodeUtil;

/* @Description:工具service实现类
 * @author: loved
 * @date: 2019年3月21日 下午2:53:38
 */
@Service
public class ToolsServiceImpl implements ToolsService {
	@Autowired
	private SmsMusicMapper smsMusicMapper;
	@Autowired
	private QRcodeMapper qrmapper;
	
	@Override
	public String getQRCode(String url) {
		// TODO Auto-generated method stub
		String content=url;//需要转换的字符串内容
		
		
		QRCode ifExist = qrmapper.selectQRcode(content);//查找是否存在
		
		int result=0;
		String res=null;
		if (ifExist==null) {
			System.out.println("不存在，新建二维码");
			Date date = new Date();//用当前时间的毫秒数作为文件名
			long time = date.getTime();
			String name = Integer.toString((int) time);
			
			String parentFolder="E:/EclipseGDOU/MusicSharing/WebContent/static/images/QRimg";//父文件夹路径
//			如果在本地就用绝对地址，如果在阿里云就用相对地址
			File ifTrue = new File("E:/EclipseGDOU/MusicSharing/WebContent/static/images/QRimg");
			if (!ifTrue.exists()) {
//				File parent = new File("WebContent");
				ifTrue= new File("webapps/MusicSharing/static/images/QRimg");
				ifTrue.mkdirs();//临时加上服务器做测试
				parentFolder=ifTrue.getAbsolutePath();
				System.out.println("parentFolder:"+parentFolder);
			}
			
			File QRimage = new File(parentFolder, (name+".png"));
			System.out.println("QRimage："+QRimage.getAbsolutePath());
			System.out.println("QRimage exist:"+QRimage.exists());
			try {
				QRCodeUtil.qrCodeEncode(content, QRimage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String storePath="images/QRimg/"+QRimage.getName();//保存到数据库的相对路径
			res=storePath;
			
			QRCode qrCode = new QRCode();
			qrCode.setContent(content);
			qrCode.setQr_path(storePath);
			result= qrmapper.addQRCode(qrCode);
			
		}else {
			System.out.println("已存在，直接返回数据库二维码");
			res=ifExist.getQr_path();
		}
		
//		if (result==1) {
//			res=storePath;//如果添加成功，则返回数据库中保存的相对路径
//		}
		return res;
	}

	@Override
	public String getSms_id(String href) {
		// TODO Auto-generated method stub
		String[] split = href.split("id=");
		return split[1];
	}

	@Override
	public String getHostName(String href) {
		// TODO Auto-generated method stub
		String[] split = href.split("page");
		return split[0];
	}

	
	
	/* (non-Javadoc)检测token是否有效
	 * @see com.lee.service.ToolsService#CheckToken(String, HttpServletRequest)
	 */
	@Override
	public boolean CheckToken(String token, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Boolean result=true;
		String a = token;
		Object b = request.getSession().getAttribute("token");
		if (token!=null&&b!=null) {
			if (b.equals(a)) {
				result=true;
			} else {
				result=false;
			}
		}else {
			result=false;
		}
		
		return result;
	}

	@Override
	public int getNewSmsId(int fk_user_id) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUser_id(fk_user_id);
		List<SmsMusic> listSmsMusic = smsMusicMapper.listSmsMusic(user);
		System.out.println("listSmsMusic:"+listSmsMusic.toString());
		int sms_id = listSmsMusic.get(0).getSms_id();
		System.out.println("当前的sms_id为："+sms_id);
		return sms_id;
	}
}

