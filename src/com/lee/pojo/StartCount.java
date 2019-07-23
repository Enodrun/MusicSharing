package com.lee.pojo;
/* @Description:分页实体
 * @author: loved
 * @date: 2019年3月22日 下午12:48:30
 */
public class StartCount {
	private int start;
	private int count;
	private String token;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}

