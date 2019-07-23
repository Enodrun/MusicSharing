package com.lee.pojo;
//用户私信
public class Letter {
	private int letter_id;
	private int fk_user_send;//私信发送者
	private String sendName;
	private int fk_user_receive;//私信接收者
	private String receiveName;
	private String datetime;
	private String content;//私信内容
	private String token;
	
	
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getLetter_id() {
		return letter_id;
	}
	public void setLetter_id(int letter_id) {
		this.letter_id = letter_id;
	}
	
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getFk_user_send() {
		return fk_user_send;
	}
	public void setFk_user_send(int fk_user_send) {
		this.fk_user_send = fk_user_send;
	}
	public int getFk_user_receive() {
		return fk_user_receive;
	}
	public void setFk_user_receive(int fk_user_receive) {
		this.fk_user_receive = fk_user_receive;
	}
	@Override
	public String toString() {
		return "Letter [letter_id=" + letter_id + ", fk_user_send=" + fk_user_send + ", fk_user_receive="
				+ fk_user_receive + ", datetime=" + datetime + ", content=" + content + ", token=" + token + "]";
	}
	
}
