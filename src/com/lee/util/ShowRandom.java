package com.lee.util;
/* @Description:
 * @author: loved
 * @date: 2019年3月19日 上午12:36:12
 */
public class ShowRandom {
	
	
	/**@Description:根据输入的图片大小的像素范围，返回随机size数值
	 * @date 2019年3月18日 下午10:33:30*/
	public int mRandom(int min,int max) {
		int result=(int)(Math.random()*(max-min+1))+min;
		return result;
	}
}

