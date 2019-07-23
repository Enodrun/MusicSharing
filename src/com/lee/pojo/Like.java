package com.lee.pojo;
/* @Description:收藏
 * @author: loved
 * @date: 2019年3月10日 下午10:13:26
 */
public class Like {
	private int like_id;
	private int fk_user_id;
	private int fk_music_id;
	private String token;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getLike_id() {
		return like_id;
	}
	public void setLike_id(int like_id) {
		this.like_id = like_id;
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
		return "Like [like_id=" + like_id + ", fk_user_id=" + fk_user_id + ", fk_music_id=" + fk_music_id + "]";
	}
	
}

