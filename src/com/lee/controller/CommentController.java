package com.lee.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.taglibs.standard.lang.jstl.BooleanLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.pojo.Comment;
import com.lee.pojo.Music;
import com.lee.service.CommentService;
import com.lee.service.ToolsService;

/* @Description:评论控制类：增加评论，删除评论，举报评论，查看评论
 * @author: loved
 * @date: 2019年3月14日 下午4:43:47
 */
@Controller
@RequestMapping("")
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private ToolsService toolsService;
	

	/**@Description:增加评论
	 * @param:comment
	 * @return:
	 * @date 2019年3月21日 下午4:51:10*/
	@ResponseBody
	@RequestMapping("/addComment")
	public HashMap<String, Boolean> addComment(@RequestBody Comment comment,HttpServletRequest request) {
		System.out.println("get:"+comment.toString());
		HashMap<String, Boolean> map = new HashMap<>();
		
		
		String token = comment.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			commentService.addComment(comment);
		}else {
			map.put("status", false);
		}
		map.put("msg", true);
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:举报评论，1为举报状态，0为正常，默认0
	 * @param:token和comment_id
	 * @return:
	 * @date 2019年3月21日 下午4:57:52*/
	@ResponseBody
	@RequestMapping("/StatusToBad")
	public HashMap<String, Boolean> CommentStatusToBad(@RequestBody Comment comment,HttpServletRequest request) {
		System.out.println("get:"+comment.toString());
		HashMap<String, Boolean> map = new HashMap<>();
		
		String token = comment.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			comment.setStatus(1);
			commentService.updateCommentStatus(comment);
		}else {
			map.put("status", false);
		}
		map.put("msg", true);
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:更正评论，修改状态为0正常;
	 * @param:token,comment_id
	 * @return:
	 * @date 2019年3月21日 下午5:02:50*/
	@ResponseBody
	@RequestMapping("/StatusToGood")
	public HashMap<String, Boolean> CommentStatusToGood(@RequestBody Comment comment,HttpServletRequest request) {
		System.out.println("get:"+comment.toString());
		HashMap<String, Boolean> map = new HashMap<>();
		
		String token = comment.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			comment.setStatus(0);
			commentService.updateCommentStatus(comment);
		}else {
			map.put("status", false);
		}
		map.put("msg", true);
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	
	/**@Description:查看评论列表，返回评论状态为0或1的所有评论列表
	 * @param:token,status
	 * @return:
	 * @date 2019年3月21日 下午5:06:55*/
	@ResponseBody
	@RequestMapping("/selectComment")
	public HashMap<String, Object> selectComment(@RequestBody Comment comment,HttpServletRequest request) {
		System.out.println("get:"+comment.toString());
		HashMap<String,Object> map = new HashMap<>();
		
		String token = comment.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			List<Comment> listCommentByStatus = commentService.listCommentByStatus(comment.getStatus());//获取相应评论状态的评论
			map.put("msg", listCommentByStatus);
		}else {
			map.put("status", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:查询该歌曲下的评论列表
	 * @param:token,music_id
	 * @return:
	 * @date 2019年3月21日 下午5:08:18*/
	@ResponseBody
	@RequestMapping("/selectCommentByMusicId")
	public HashMap<String, Object> SelectByMusicId(@RequestBody Music music,HttpServletRequest request) {
		System.out.println("get："+music.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		String token = music.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", 1);
			List<Comment> listCommentByMusic = commentService.listCommentByMusic(music.getMusic_id());//根据歌曲id返回评论列表
			map.put("msg", listCommentByMusic);
		}else {
			map.put("status", 0);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:删除评论
	 * @param:token,comment_id
	 * @return:
	 * @date 2019年3月21日 下午5:11:14*/
	@ResponseBody
	@RequestMapping("/deleteCommentById")
	public HashMap<String, Boolean> deleteCommentById(@RequestBody Comment comment,HttpServletRequest request) {
		System.out.println("get："+comment.toString());
		HashMap<String, Boolean> map = new HashMap<>();
		
		String token = comment.getToken();//获取token
		boolean checkToken = toolsService.CheckToken(token, request);//比对token的值
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			commentService.deleteCommentInOne(comment.getComment_id());
			map.put("msg", true);
		}else {
			map.put("status", false);
			map.put("status", false);
		}
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
}

