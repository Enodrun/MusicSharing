package com.lee.pojo;
//歌曲评论
public class Comment {
	private int comment_id;
	private int fk_user_id;
	private int fk_music_id;
	private String datetime;
	private String content;
	private int status=0;//默认0,评论正常
	
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public int getFk_user_id() {
		return fk_user_id;
	}
	public void setFk_user_id(int fk_user_id) {
		this.fk_user_id = fk_user_id;
	}
	public int getFk_music_id() {
		return fk_music_id;
	}
	public void setFk_music_id(int fk_music_id) {
		this.fk_music_id = fk_music_id;
	}
	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", fk_user_id=" + fk_user_id + ", fk_music_id=" + fk_music_id
				+ ", datetime=" + datetime + ", content=" + content + ", status=" + status + "]";
	}
}
