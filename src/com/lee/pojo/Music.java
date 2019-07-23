package com.lee.pojo;

import org.springframework.web.multipart.MultipartFile;

//音乐信息
public class Music {
	private int music_id;
	private String name;
	private String file;//音乐路径
	private String cover;//封面路径
	private int fk_user_id;//上传者id
	private int likes;//收藏人数
	private String words;//上传者评价
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	private String showPicture;//动画效果的音乐照片
	private int showSize;//动画效果的图片大小
	public String getShowPicture() {
		return showPicture;
	}
	public void setShowPicture(String showPicture) {
		this.showPicture = showPicture;
	}
	public int getShowSize() {
		return showSize;
	}
	public void setShowSize(int showSize) {
		this.showSize = showSize;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	private MultipartFile picture;
	private MultipartFile music;
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
	public int getMusic_id() {
		return music_id;
	}
	public void setMusic_id(int music_id) {
		this.music_id = music_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public int getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(int fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "Music [music_id=" + music_id + ", name=" + name + ", file=" + file + ", cover=" + cover + ", fk_user_id="
				+ fk_user_id + ", likes=" + likes + ", words=" + words + ", showPicture=" + showPicture + ", showSize="
				+ showSize + ", picture=" + picture + ", music=" + music + "]";
	}
	
}
