package com.lee.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.pojo.QRCode;
import com.lee.service.ToolsService;

/* @Description:音乐分享功能
 * @author: loved
 * @date: 2019年3月31日 下午10:50:55
 */
@Controller
@RequestMapping("")
public class ShareTheUrl {
	@Autowired
	private ToolsService toolsService;
	
	/**@Description:前端传送网址的url,返回该网址的分享二维码图片
	 * @param:
	 * @return:
	 * @date 2019年3月31日 下午11:03:08*/
	@ResponseBody
	@RequestMapping("/ShareUrl")
	public HashMap<String, Object> ShareUrl(@RequestBody QRCode url ){
		System.out.println("get:"+url.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		if (url.getUrl()!=null) {
			String qrCode = toolsService.getQRCode(url.getUrl());//调用工具类生成qrCode图片地址
			map.put("msg", qrCode);
		}
		return map;
	}
}

