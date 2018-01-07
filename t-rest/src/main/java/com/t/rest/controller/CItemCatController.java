package com.t.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.commom.utils.JsonUtils;
import com.t.rest.service.IItemCatService;

/**
 * 商品类别管理 Controller
 * <p>Title: CItemCatController</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月13日下午7:28:37
 * @version 1.0
 */
@Controller("cItemCatController")
public class CItemCatController {

	@Autowired
	private IItemCatService iItemCatService;
	
	/**
	 * 返回跨域请求的js包装的 商品类别的JSON数据格式
	 * <p>Title: listAllItemCat</p>
	 * <p>Description: </p>
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/itemcat/list", produces = "text/html;charset=UTF-8")
	public String listAllItemCat(String callback) throws Exception {
		String jsonResult = iItemCatService.queryAllItemCate();
		//拼接字符串
		String resultStr = callback + "(" + jsonResult + ");";
		return resultStr;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/itemcat/list2", produces = "text/html;charset=UTF-8")
	public String listAllItemCat2() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("AA", null);
		map.put("BB", "BB");
		String objectToJson = JsonUtils.objectToJson(map);
		return objectToJson;
	}
	
	@ResponseBody
	@RequestMapping(value = "/itemcat/list3", produces = "text/html;charset=UTF-8")
	public String listAllItemCat3() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("AA", "null");
		map.put("BB", "BB");
		map.put("null", "CC");
		String objectToJson = JsonUtils.objectToJson(map);
		return objectToJson;
	}
	
}
