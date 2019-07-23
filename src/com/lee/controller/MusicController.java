package com.lee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.pojo.Music;
import com.lee.pojo.StartCount;
import com.lee.pojo.User;
import com.lee.service.LikeService;
import com.lee.service.MusicService;
import com.lee.service.ToolsService;
import com.lee.util.Page;
import com.lee.util.RandomPage;
import com.lee.util.ShowMusic;

/* @Description:音乐相关控制类：音乐分页查询
 * @author: loved
 * @date: 2019年3月14日 上午10:12:59
 */
@Controller
@RequestMapping("")
public class MusicController {
	@Autowired
	private MusicService musicService;
	@Autowired
	private LikeService likeService;
	@Autowired
	private ToolsService toolService;
	
	
	/**@Description:分页查询音乐,每个封面按照likes的数值设置随机的大小,返回前端
	 * @date 2019年3月14日 上午10:54:19*/
	@ResponseBody
	@RequestMapping("/selectMusicByPage")
	public HashMap<String, Object> selectMusicByPage() {
		
		RandomPage randomPage = new RandomPage();//调用工具类生成随机分页
		Page page = randomPage.getPage(musicService.totalMusic(), 5, 10, 21, true);//参数为：音乐总数，每页最少数，最大数，固定数，固定数是否有效
		List<Music> listMusicByPage = musicService.listMusicByPage(page);
		
		ShowMusic showMusic = new ShowMusic();//调用工具类生成随机图片地址和图片大小
		
		
		ArrayList<Music> list = new ArrayList<Music>(); //存储必要的歌曲信息列表，返回前端
		String folder="UI/img/";//放置形状图片的文件夹
		List<Integer> showNum = showMusic.getDensity(8, listMusicByPage.size());//设置音乐的显示密度，第一个参数
		for (int i = 0; i < listMusicByPage.size(); i++) {
			Music music = new Music();//存储歌曲信息实体	
			if (showNum.contains(i)) {
					music.setMusic_id(listMusicByPage.get(i).getMusic_id());//歌曲id
					music.setName(listMusicByPage.get(i).getName());//音乐名字
					music.setCover(listMusicByPage.get(i).getCover());//音乐封面
					music.setShowSize(showMusic.mSize(listMusicByPage.get(i).getLikes()));//动画尺寸
					music.setShowPicture(showMusic.mPicture(10, folder));//动画形状
					
					list.add(music);//如果随机数包含该数则添加歌曲信息
				}else {
					list.add(music);//如果随机数不包含该数则添加空的歌曲信息
				}
			}			
		
		HashMap<String, Object> map = new HashMap<>();//放入键值对中准备传回前端
		map.put("show", list);
		
		return map;
	}
	
	/**@Description:根据音乐id搜索音乐信息
	 * @date 2019年3月20日 下午4:09:56*/
	@ResponseBody
	@RequestMapping("/selectMusicById")
	public HashMap<String, Object> SelectMusicById(@RequestBody Music music) {
		System.out.println("接收到："+music.getMusic_id());
		int music_id = music.getMusic_id();
		
		Music selectMusicById = musicService.selectMusicById(music_id);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("music", selectMusicById);
		System.out.println("map："+map.toString());
		return map;
	}
	
	
	/**@Description:我的上传列表，根据上传者id搜索自己上传的歌曲
	 * @param:user_id
	 * @return:
	 * @date 2019年3月25日 下午6:03:21*/
	@ResponseBody
	@RequestMapping("/listMusicByUserId")
	public HashMap<String, Object> ListMusicByUserId(@RequestBody User user,HttpServletRequest request) {
		System.out.println("get："+user.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		String token = user.getToken();
		boolean checkToken = toolService.CheckToken(token, request);
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			List<Music> listMusicByUser = musicService.listMusicByUser(user);
			map.put("msg", listMusicByUser);
		}else {
			map.put("status", false);
		}
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:根据music_id删除音乐,要是上传着本人才能删除
	 * @param:music_id;
	 * @return:void
	 * @date 2019年3月25日 下午6:28:13*/
	@ResponseBody
	@RequestMapping("/deleteMusicById")
	public HashMap<String, Boolean> deleteMusicById(@RequestBody Music music,HttpServletRequest request) {
		System.out.println("get："+music.toString());
		HashMap<String, Boolean> map = new HashMap<>();
		
		String token = music.getToken();
		boolean checkToken = toolService.CheckToken(token, request);
//		Boolean checkToken=true;//假数据，测试
		if (checkToken) {
			map.put("status", true);
			musicService.deleteMusicById(music.getMusic_id());
			map.put("msg", true);
		}else {
			map.put("status", false);
		}
		map.put("msg", false);
		
		System.out.println("map:"+map.toString());
		return map;
	}
	
	/**@Description:查询音乐，得到随机的分页数据，每张专辑的图片等宽
	 * @param:每页的展示的数量，count
	 * @return:音乐列表
	 * @date 2019年3月26日 下午11:42:33*/
	@ResponseBody
	@RequestMapping("/selectMusicByPageRandom")
	public HashMap<String, Object> selectMusicByPageRandom(@RequestBody StartCount count) {
		System.out.println("get:"+count.toString());
		HashMap<String, Object> map = new HashMap<>();//放入键值对中准备传回前端
		
		RandomPage randomPage = new RandomPage();//调用工具类生成随机分页
		Page page = randomPage.getPage(musicService.totalMusic(), 5, 10, count.getCount(), true);//参数为：音乐总数，每页最少数，最大数，固定数，固定数是否有效
		List<Music> listMusicByPage = musicService.listMusicByPage(page);
		
		map.put("msg", listMusicByPage);
		return map;
	}
}

