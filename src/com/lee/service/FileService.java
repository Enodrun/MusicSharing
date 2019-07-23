package com.lee.service;
/* @Description:
 * @author: loved
 * @date: 2019年3月20日 下午10:27:47
 */

import java.io.File;
import java.io.IOException;

public interface FileService {
//在vip文件夹中创建根据user_id创建个人文件夹，并创建不重复文件名，保存在数据库中
	File savePicture(int user_id) throws IOException;
}

