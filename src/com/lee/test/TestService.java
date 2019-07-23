package com.lee.test;


import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.mapper.LyricMapper;
import com.lee.pojo.Comment;
import com.lee.pojo.Like;
import com.lee.pojo.Lyric;
import com.lee.pojo.QRCode;
import com.lee.pojo.SmsMusic;
import com.lee.service.CommentService;
import com.lee.service.LikeService;
import com.lee.service.LyricService;
import com.lee.service.MusicService;
import com.lee.service.QRCodeService;
import com.lee.service.SmsMusicService;
import com.lee.service.ToolsService;
import com.lee.util.Page;
import com.lee.util.RandomPage;

/* @Description:
 * @author: loved
 * @date: 2019年3月11日 下午1:56:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestService {
	@Autowired
	private CommentService commentService;
	@Autowired
	private MusicService musicService;
	@Autowired
	private ToolsService toolsService;
	@Autowired
	private SmsMusicService smsMusicService;
	@Autowired
	private QRCodeService qrCodeService;
	@Autowired
	private LyricService lyricService;
	@Autowired
	private LyricMapper lyricMapper;
	@Autowired
	private LikeService likeService;
//	@Test
	public void add() {
		Comment comment = new Comment();
		comment.setFk_user_id(10);
		comment.setFk_music_id(4);
		comment.setContent("年度最佳音乐");
		int addComment = commentService.addComment(comment);
		System.out.println(addComment);
	}
//	@Test
	public void totalMusic() {
		int totalMusic = musicService.totalMusic();
		System.out.println("count:"+totalMusic);
	}
	
//	@Test
	public void RandomPage() {
		RandomPage randomPage = new RandomPage();
		Page page = randomPage.getPage( musicService.totalMusic(),5, 10, 15, false);
		System.out.println(page);
	}
	
//	@Test
	public void ToolsService01() {
		int fk_user_id=22;
		int newSmsId = toolsService.getNewSmsId(fk_user_id);
		System.out.println("result:"+newSmsId);
	}
	
//	@Test
	public void ToolsService02() {
		String test="http://localhost:8080/MusicSharing/static/page/%E7%82%B9%E6%92%AD%E6%94%B6%E5%90%AC.html";
		String hostName = toolsService.getHostName(test);
		System.out.println("host="+hostName);
	}
	
//	@Test
	public void SmsMusic01() {
		SmsMusic smsMusic = new SmsMusic();
		smsMusic.setSms_id(38);
		smsMusic.setCommand("嘛哩嘛哩哄");
		
		SmsMusic result = smsMusicService.selectSmsMusicBySmsIdAndCommand(smsMusic);
		System.out.println("result="+result);
	}
	
//	@Test
	public void ToolsService03() {
		String test="http://localhost:8080/MusicSharing/static/page/soud.html?id=32";
		String sms_id = toolsService.getSms_id(test);
		System.out.println("sms_id="+sms_id);
	}
	
//	@Test
	public void QRservice() {
		QRCode qrCode = new QRCode();
		qrCode.setQr_path("testPATH");
		qrCode.setContent("testContent");
		int addQRcode = qrCodeService.addQRcode(qrCode);
		System.out.println("int="+addQRcode);
		QRCode selectQRcode = qrCodeService.selectQRcode(qrCode.getContent());
		System.out.println("select="+selectQRcode.toString());
	}
	
//	@Test
	public void qrtools() {
		String qrCode = toolsService.getQRCode("猪猪是个大美女~");
		System.out.println("path="+qrCode);
	}
	
//	@Test
	public void lyric(){
		Lyric lyric = new Lyric();
		lyric.setClassify(1);
		lyric.setLyric_music_id(48);
		lyric.setTime("22");
		lyric.setContent("第一句歌词");
		
//		lyricMapper.addLyric(lyric);
//		lyricService.add(lyric);
		List<Lyric> list = lyricService.list(lyric);
		System.out.println(list.toString());
		
	}
	
//	@Test
	public void confirmLike() {
		Like like = new Like();
		like.setFk_user_id(39);
		like.setFk_music_id(233);
		Like confirmLike = likeService.confirmLike(like);
		System.out.println(confirmLike.toString());
	}
	
	@Test
	public void disLike() {
		Like like = new Like();
		like.setFk_user_id(42);
		like.setFk_music_id(219);
		int disLike = likeService.disLike(like);
		System.out.println(disLike);
	}
}

