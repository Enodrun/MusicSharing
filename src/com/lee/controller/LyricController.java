package com.lee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.lang.model.element.VariableElement;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.sql.visitor.functions.Length;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lee.pojo.Lyric;
import com.lee.pojo.User;
import com.lee.service.LyricService;

/* @Description:
 * @author: loved
 * @date: 2019年4月4日 下午8:54:20
 */
@Controller
@RequestMapping("")
public class LyricController {
	@Autowired
	private LyricService lyricService;
	
	/**@Description:先判断是否已存在该歌曲歌词,添加歌词
	 * @param：
	 * @return:成功信息
	 * @date 2019年4月4日 下午8:57:52*/
	@ResponseBody
	@RequestMapping("/addLyric")
	public HashMap<String, Object> addLyric(@RequestBody JSONObject jsonObject) {
		System.out.println("get:"+jsonObject.toString());//前端json数据
		int music_id = (int)jsonObject.get("music_id");
		int classify = (int)jsonObject.get("classify");
	    ArrayList allKeyValue = (ArrayList)jsonObject.get("allKeyValue");
			int length = ((ArrayList)jsonObject.get("allKeyValue")).size();
		System.out.println("allKeyValue:"+allKeyValue+"length:"+length);
		Lyric lyric = new Lyric();
		lyric.setLyric_music_id(music_id);//设置music_id
		lyric.setClassify(classify);//设置classify
		
		
		HashMap<String, Object> map = new HashMap<>();
		if (lyric!=null) {
			List<Lyric> list = lyricService.list(lyric);
			System.out.println("list:"+list.toString());
			if (list.size()==0) {
				for (int i = 0; i < length; i=i+2) {
					String timeTemp = allKeyValue.get(i).toString();//时间戳键值对
					String contentTemp = allKeyValue.get(i+1).toString();//该时间戳的歌词键值对
					
					String timeValue=timeTemp.split("value=")[1];//时间戳值
					String contentValue=contentTemp.split("value=")[1];//歌词值
					
					String time=timeValue.substring(0, timeValue.length()-1);//除掉末尾的}号：content=歌词2}
					String content=contentValue.substring(0, contentValue.length()-1);
					
					lyric.setTime(time);
					lyric.setContent(content);
					lyricService.add(lyric);//加入该条歌词
					System.out.println("add finish:"+lyric.toString());
				}
				map.put("status", true);//全部插入成功
			}else {
				map.put("status", false);//该歌曲歌词已存在,插入失败
			}
		}
		
		System.out.println("send:"+map.toString());
		return map;
	}
	
	
	/**@Description:根据classify和lyric_music_id查询此歌词
	 * @param:classify和lyric_music_id
	 * @return:歌词数组
	 * @date 2019年4月4日 下午8:59:45*/
	@ResponseBody
	@RequestMapping("/listLyric")
	public HashMap<String, Object> listLyric(@RequestBody JSONObject jsonObject) {
		System.out.println("get:"+jsonObject.toString());
		HashMap<String, Object> map = new HashMap<>();
		Lyric lyric = new Lyric();//把json类型转换成int类型
			int music_id = Integer.valueOf((String) jsonObject.get("music_id"));
			int classify = (int)jsonObject.get("classify");
			
			lyric.setLyric_music_id(music_id);
			lyric.setClassify(classify);
		if (lyric!=null) {
			List<Lyric> list = lyricService.list(lyric);
			map.put("msg", list);
			map.put("status", true);
		}else {
			map.put("status", false);
		}
		
		System.out.println("send:"+map.toString());
		return map;
	}

}

