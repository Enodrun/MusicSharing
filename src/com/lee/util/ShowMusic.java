package com.lee.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/* @Description:实现前端动画展示音乐列表的相关方法
 * @author: loved
 * @date: 2019年3月18日 下午9:40:27
 */
public class ShowMusic {
	
	/**@Description:根据歌曲中like的数量，返回五个等级的随机数图片大小值，作为img.src的width和height
	 * @date 2019年3月18日 下午10:19:08*/
	public int mSize(int likeNumber) {
		int count=likeNumber;
		int size=0;
		
		ShowRandom showMusic = new ShowRandom();
		if (0<=count&&count<=10) {//like的数量
			int mRandom = showMusic.mRandom(10, 30);//歌曲图片的大小
			size=mRandom;
		} else if (10<count&&count<=20) {
			int mRandom = showMusic.mRandom(31, 60);
			size=mRandom;
		} else if (20<count&&count<=30) {
			int mRandom = showMusic.mRandom(61, 90);
			size=mRandom;
		} else if (30<count&&count<=40) {
			int mRandom = showMusic.mRandom(91, 120);
			size=mRandom;
		} else {//收藏数大于40
			int mRandom = showMusic.mRandom(121, 150);
			size=mRandom;
		}
		System.out.println("likeNumber-size："+likeNumber+"-"+size);
		return size;
	}
	
	/**@Description:输入count参数（数值越大形状的重复率越小，最大为10,即文件中标号1到10 的照片）
	 * @date 2019年3月18日 下午11:04:24*/
	public String mPicture(int count,String folder) {
		
		String path = new String();
		int num=new ShowRandom().mRandom(1, 10);
		path=folder+num+".jpg";
		return path;
	}
	
	/**@Description:控制图片输出的密度，参数：1——10代表密度百分百，total代表布局的图片总数
	 * @date 2019年3月19日 下午1:29:42*/
	public List<Integer> getDensity(int threeeToEight,int total) {
		int number=(int) Math.ceil(threeeToEight*total/10);//总数的百分之几
		int count=total;
		
		//在总数中取若干个个不重复的随机数,threeToEnght/total个随机数
		ArrayList<Integer> random = new ArrayList<Integer>();//存不重复随机数
		for (int i = 0; i < number+1; i++) {
			if (i==0) {
				int x=(int)(Math.random()*(count+1));
				random.add(x);
				System.out.println("add:x-"+i);
			} else {
				int y=(int)(Math.random()*(count+1));
				if (random.contains(y)) {
					i=i-1;
					System.out.println("y"+i);
				}else {
					random.add(y);
					System.out.println("add:y-"+i);
				}
			}
		}
		
		return random;
	}
}

