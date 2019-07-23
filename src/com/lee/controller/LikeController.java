package com.lee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.pojo.Letter;
import com.lee.pojo.Like;
import com.lee.pojo.Music;
import com.lee.pojo.User;
import com.lee.service.LikeService;
import com.lee.service.MusicService;
import com.lee.service.ToolsService;
import com.lee.service.UserService;

/* @Description:歌曲收藏相关操作
 * @author: loved
 * @date: 2019年3月14日 下午6:10:22
 */
@Controller
@RequestMapping("")
public class LikeController {
	@Autowired
	private LikeService likeService;
	@Autowired
	private MusicService musicService;
	@Autowired
	private UserService userService;
	@Autowired
	private ToolsService toolsService;
	
	/**@Description:增加一条收藏记录， 根据音乐ID和用户ID收藏音乐,并更新数据库中该音乐的收藏数量likes[<Like>fk_music_id]
	 * [<Like>fk_music_id,fk_user_id]
	 * @date 2019年3月14日 下午4:19:22*/
	@ResponseBody
	@RequestMapping("addLike")
	public HashMap<String, Boolean> SelectMusicByMusicId(@RequestBody Like like,HttpServletRequest request) {
		System.out.println("get:"+like.toString());
		HashMap<String, Boolean> map = new HashMap<>();
		
		String token = like.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		Like confirmLike = likeService.confirmLike(like);//检查是否已收藏
		if (checkToken==true&&confirmLike==null) {
			map.put("status",true);
			likeService.addLike(like);//添加收藏记录
			System.out.println("addLike finish");
			//更新相应的歌曲收藏数+1
			Music music = new Music();
			music.setMusic_id(like.getFk_music_id());
			musicService.updateMusicInLikes(music);
			map.put("msg", true);
		}else {
			map.put("status", false);
			map.put("msg", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	@ResponseBody
	@RequestMapping("dislike")
	public HashMap<String, Boolean> DisLike(@RequestBody Like like,HttpServletRequest request){
		System.out.println("get:"+like.toString());
		HashMap<String, Boolean> map=new HashMap<>();
		
		String token = like.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		Like confirmLike = likeService.confirmLike(like);//检查是否已收藏
		if (checkToken==true&&confirmLike!=null) {
			map.put("status",true);
			likeService.disLike(like);//添加收藏记录
			System.out.println("disLike finish");
			map.put("msg", true);
		}else {
			map.put("status", false);
			map.put("msg", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:输入<Like>fk_music_id;返回fk_user_id等用户信息；（即查询某首歌的收藏用户有哪些）
	 * @date 2019年3月14日 下午6:20:48*/
	@ResponseBody
	@RequestMapping("/listLikeByMusic")
	public HashMap<String,Object> listPeopleWhoLike(@RequestBody Like like,HttpServletRequest request) {
		System.out.println("get:"+like.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		String token = like.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status",true);
			List<Like> userIdWhoLike = likeService.listLikeByMusic(like);//收藏这首歌的人
			System.out.println("1:"+userIdWhoLike.toString());
			ArrayList<User> userInfo = new ArrayList<>();//根据用户id找到该用户的非敏感信息
			for (Like info : userIdWhoLike) {
				User user = userService.getUserInfo(info.getFk_user_id());
				System.out.println("user:"+user.toString());
				userInfo.add(user);
			}
			map.put("msg", userInfo);
		}else {
			map.put("status", false);
			map.put("msg", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:输入fk_user_id，返回该用户收藏的所有音乐
	 * @date 2019年3月14日 下午6:54:35*/
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("/listMusicByOne")
	public HashMap<String, Object> listMusicOneLike(@RequestBody Like like,HttpServletRequest request) {
		System.out.println("get:"+like.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		String token = like.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status",true);
			List<Like> music_ids = likeService.listLikeByUser(like);
			ArrayList<Music> audios = new ArrayList<>();
			for (Like ids : music_ids) {
				Music music = musicService.selectMusicById(ids.getFk_music_id());
				audios.add(music);
			}
			map.put("msg", audios);
		}else {
			map.put("status", false);
			map.put("msg", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
}

