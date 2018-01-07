package com.t.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.commom.utils.TResult;
import com.t.rest.service.IContentService;

/**
 * 商品管理的ontroller 包括类别管理
 * <p>Title: CContentController</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月13日下午10:49:12
 * @version 1.0
 */
@Controller("cContentController")
@RequestMapping("/content")
public class CContentController {
	
	@Autowired
	private IContentService iContentService;
	
	/**
	 * 发布服务 根据cid返回 商品内容列表
	 * <p>Title: getContentListByCategory</p>
	 * <p>Description: </p>
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/category/{cid}")
	public TResult getContentListByCategory(@PathVariable Long cid) {
		TResult result = null;
		Map<String, Object> map = new HashMap<>();
		map.put("categoryId", cid);
		try {
			result = iContentService.getContentListByCategory(map);
		} catch (Exception e) {
			e.printStackTrace();
			return TResult.build(500, e.getMessage());
		}
		return result;
	}
}
