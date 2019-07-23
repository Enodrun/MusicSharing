package com.lee.pojo;

import org.springframework.web.multipart.MultipartFile;

//用户信息
public class User {
	private int user_id;
	private String name;
	private String password;
	private String confirm;
	private String token;
	
	private String nick_name;
	private String head_picture;
	private String mail;
	
	private MultipartFile head_file;//暂存头像图片文件对象
	
	public MultipartFile getHead_file() {
		return head_file;
	}
	public void setHead_file(MultipartFile head_file) {
		this.head_file = head_file;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getHead_picture() {
		return head_picture;
	}
	public void setHead_picture(String head_picture) {
		this.head_picture = head_picture;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", password=" + password + ", confirm=" + confirm
				+ ", nick_name=" + nick_name + ", head_picture=" + head_picture + ", mail=" + mail + "]";
	}
	
}
