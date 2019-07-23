package com.lee.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lee.pojo.Category;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {
    @ResponseBody
	@RequestMapping("/submitCategory")
    public String submitCategory(@RequestBody Category category) {
		System.out.println("SSM接受到浏览器提交的json，并转换为Category对象:"+category);
		JSONObject res = new JSONObject();
		res.put("result", "ok");
        return res.toJSONString();
    }
    
    @ResponseBody
    @RequestMapping("/getOneCategory")
    public String getOneCategory() {
    	 Category c = new Category();
         c.setId(550);
    	 c.setName("第100个分类");
         JSONObject json= new JSONObject();
         json.put("category", JSONObject.toJSON(c));
      	 return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/getManyCategory")
    public String getManyCategory() {
    	List<Category> cs = new ArrayList<>();
    	for (int i = 0; i < 10; i++) {
			Category c = new Category();
			c.setId(i);
			c.setName("分类名称:"+i);
			cs.add(c);
		}

    	return JSONObject.toJSON(cs).toString();
    }


}
