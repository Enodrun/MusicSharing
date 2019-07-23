package com.lee.pojo;
/* @Description:歌词实体类
 * @author: loved
 * @date: 2019年4月4日 下午8:23:51
 */
public class Lyric {
	private int lyric_id;
	private int classify;//分类，0代表music表的歌词，1代表sms_music表的歌词
	private int lyric_music_id;
	private String time;
	private String content;
	
	private String allKeyValue;//歌词前端页面被序列化的所有时间点+歌词内容键值对组合
	
	public String getAllKeyValue() {
		return allKeyValue;
	}
	public void setAllKeyValue(String allKeyValue) {
		this.allKeyValue = allKeyValue;
	}
	public int getLyric_id() {
		return lyric_id;
	}
	public void setLyric_id(int lyric_id) {
		this.lyric_id = lyric_id;
	}
	public int getClassify() {
		return classify;
	}
	public void setClassify(int classify) {
		this.classify = classify;
	}
	public int getLyric_music_id() {
		return lyric_music_id;
	}
	public void setLyric_music_id(int lyric_music_id) {
		this.lyric_music_id = lyric_music_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Lyric [lyric_id=" + lyric_id + ", classify=" + classify + ", lyric_music_id=" + lyric_music_id
				+ ", time=" + time + ", content=" + content + ", allKeyValue=" + allKeyValue + "]";
	}
	
}

