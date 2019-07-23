package com.lee.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.hamcrest.generator.qdox.parser.structs.FieldDef;
import org.junit.Test;

import com.lee.util.QRCodeUtil;
import com.lee.util.ShowMusic;
import com.lee.util.ShowRandom;

/* @Description:音乐动态展示效果测试类
 * @author: loved
 * @date: 2019年3月18日 下午10:47:18
 */
public class TestUtil {
	
//	@Test
	/**@Description:随机获取图片大小
	 * @date 2019年3月18日 下午11:32:22*/
	public void TestmSize() {
		ShowRandom showRandom = new ShowRandom();
		ShowMusic showMusic = new ShowMusic();
		for (int i = 0; i < 20; i++) {
			int count = showRandom.mRandom(0, 50);
			int size = showMusic.mSize(count);
			System.out.println(count+"-"+size);
		}
	}
	
//	@Test
	/**@Description:随机获取图片路径
	 * @date 2019年3月18日 下午11:32:12*/
	public void TestmPicture() {
		ShowMusic showMusic = new ShowMusic();
		String folder="UI/img/";
		for (int i = 0; i < 20; i++) {
			String path = showMusic.mPicture(10, folder);
			System.out.println(path);
		}
	}
	
	/**@Description:从总数中按百分比获取其中的随机数
	 * @date 2019年3月19日 下午3:35:06*/
//	@Test
	public void TestgetDensity() {
		ShowMusic showMusic = new ShowMusic();
		List<Integer> density = showMusic.getDensity(2, 10);
		for (int integer : density) {
			System.out.println(integer);
		}
	}
	
	/**@Description:
	 * @date 2019年3月19日 下午3:45:25*/
//	@Test
	public void temp() {
		Integer integer = new Integer(1);
		int x=1;
		System.out.println(integer==1);
	}
	
//	@Test
	/**@Description:long转字符串
	 * @date 2019年3月21日 上午10:32:27*/
	public void date() {
		Date date = new Date();
		System.out.println("Date:"+date);
		long time = date.getTime();
		System.out.println("time:"+time);
		String string = Long.toString(time);
		System.out.println("string:"+string);
	}
	
	/**@Description:测试网址生成二维码
	 * @param:
	 * @return:
	 * @throws IOException 
	 * @date 2019年3月31日 下午8:59:01*/
//	@Test
	public void testQRCode() throws IOException {
		File path = new File("D:/2.png");
		String url="hello";
		QRCodeUtil.qrCodeEncode(url, path);
	}
	@Test
	public void createFiles() {
		File parent = new File("WebContent");
		File vipFiles = new File(parent, "static/vipFiles");
		System.out.println(vipFiles.exists());
		System.out.println(vipFiles.getAbsolutePath());
		System.out.println(vipFiles.list().toString());
	}
}

