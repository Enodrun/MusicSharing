package com.lee.util;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.lee.pojo.Music;
import com.lee.pojo.User;
import com.lee.service.MusicService;

/* @Description:随机数分页功能
 * @author: loved
 * @date: 2019年3月14日 上午11:06:00
 */

public class RandomPage {
	/**@Description:随机分页：参数count为每页数量，control为控制每页的数量true是使用输入的pageCount,
	 * 					    false使用随机的count,min为每页最少值,max为每页最大值
	 * @date 2019年3月14日 下午12:48:37*/
	public Page getPage(int totalMusic,int min, int max,int pageCount,boolean control) {
		int count=1;
		int total = totalMusic;//总数
		
		if (total<=max) {//如果总数少于输入的数值，最终就从第一条输出，输出全部数据
			max=total;
			if (total<min) {
				min=total;
			}
		}
		
		if (control) {
			count=pageCount;
		}else {
			count=(int)(Math.random()*(max-min+1))+min;//count的值为min——max随机整数（包括10）
		}
		
		
		int number = total%count;//页数
		
		int start = (int)(Math.random()*(total-count));//从随机数0——倒数第二页的最后一条开始，缺点是永远取不到第一条
		
		Page page = new Page();
		page.setStart(start);
		page.setCount(count);
		
		return page;
	}
}

