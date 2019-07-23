package com.lee.pojo;
/* @Description:二维码实体类
 * @author: loved
 * @date: 2019年3月31日 下午9:29:34
 */
public class QRCode {
	private String qr_id;
	private String content;
	private String qr_path;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	private String url;
	public String getQr_id() {
		return qr_id;
	}
	public void setQr_id(String qr_id) {
		this.qr_id = qr_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getQr_path() {
		return qr_path;
	}
	public void setQr_path(String qr_path) {
		this.qr_path = qr_path;
	}
	@Override
	public String toString() {
		return "QRCode [qr_id=" + qr_id + ", content=" + content + ", qr_path=" + qr_path + ", url=" + url + "]";
	}
}

