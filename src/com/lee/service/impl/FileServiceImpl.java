package com.lee.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.lee.service.FileService;

/* @Description:
 * @author: loved
 * @date: 2019年3月20日 下午10:35:19
 */
@Service
public class FileServiceImpl implements FileService {

	/* (non-Javadoc)输入用户id，生成放置用户头像的文件夹和相应的文件对象
	 * @see com.lee.service.FileService#savePicture(int)
	 */
	@Override
	public File savePicture(int user_id) throws IOException {
		// TODO Auto-generated method stub
//		File vipFiles = new File("E:/EclipseGDOU/MusicSharing/WebContent/static/vipFiles");//vip文件夹
//		本地用绝对路径地址，阿里云用相对路径地址
		File vipFiles = new File("E:/EclipseGDOU/MusicSharing/WebContent/static/vipFiles");//vip文件夹
		if (!vipFiles.exists()) {
//			File parent = new File("WebContent");
			vipFiles = new File("static/vipFiles");
		}
		
		String folderName = Integer.toString(user_id);//根据上传者ID创建专用文件夹
		File folderPersonal = new File(vipFiles, folderName);
		if (!folderPersonal.exists()) {//如果文件夹不存在则新建一个
			folderPersonal.mkdirs();
		}
		File headFolder = new File(folderPersonal, "head");//如果头像文件夹不存在则新建一个
		if (!headFolder.exists()) {
			headFolder.mkdirs();
		}

		Date date = new Date();//获取日期
		long time = date.getTime();
		String fileName = Long.toString(time)+".jpg";//以当前时间毫秒数作为文件名
		File pictureFile = new File(headFolder, fileName);//图片文件对象

		return pictureFile;
	}

}

