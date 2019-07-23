package com.lee.pojo;

import org.springframework.web.multipart.MultipartFile;

//专门上传给某人的音乐信息
public class SmsMusic {
	private int sms_id;
	private int fk_user_id;//上传者id
	private String tel;//上传者手机号
	private String command;//观看口令
	private String datetime;
	private String letter;//回信
	private String title;
	private String send;//发送者名字
	private String receive;//接收者名字
	private String receive_tel;//接收短信的手机号
	private String music_path;//音乐文件路径
	private String picture_path;//配图路径
	private String wish;//短信祝福
	private String words;//想说的话
	private MultipartFile picture;//图片文件对象
	private MultipartFile music;//音乐文件对象 
	private String url;//临时注入字符串类型的fk_user_id
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	public MultipartFile getMusic() {
		return music;
	}
	public void setMusic(MultipartFile music) {
		this.music = music;
	}
	public int getSms_id() {
		return sms_id;
	}
	public void setSms_id(int sms_id) {
		this.sms_id = sms_id;
	}
	public int getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(int fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	public String getReceive() {
		return receive;
	}
	public void setReceive(String receive) {
		this.receive = receive;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getReceive_tel() {
		return receive_tel;
	}
	public void setReceive_tel(String receive_tel) {
		this.receive_tel = receive_tel;
	}
	public String getMusic_path() {
		return music_path;
	}
	public void setMusic_path(String music_path) {
		this.music_path = music_path;
	}
	public String getPicture_path() {
		return picture_path;
	}
	public void setPicture_path(String picture_path) {
		this.picture_path = picture_path;
	}
	public String getWish() {
		return wish;
	}
	public void setWish(String wish) {
		this.wish = wish;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	@Override
	public String toString() {
		return "SmsMusic [sms_id=" + sms_id + ", fk_user_id=" + fk_user_id + ", tel=" + tel + ", command=" + command
				+ ", datetime=" + datetime + ", letter=" + letter + ", title=" + title + ", send=" + send + ", receive="
				+ receive + ", receive_tel=" + receive_tel + ", music_path=" + music_path + ", picture_path="
				+ picture_path + ", wish=" + wish + ", words=" + words + ", picture=" + picture + ", music=" + music
				+ ", url=" + url + "]";
	}
}
