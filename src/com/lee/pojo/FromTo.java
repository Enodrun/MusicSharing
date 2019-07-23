package com.lee.pojo;
/* @Description:根据user_id换成用户name属性
 * @author: loved
 * @date: 2019年4月7日 上午10:33:19
 */
public class FromTo {
	private int fromId;
	private int toId;
	private String fromName;
	private String toName;
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
	public int getToId() {
		return toId;
	}
	public void setToId(int toId) {
		this.toId = toId;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
}

