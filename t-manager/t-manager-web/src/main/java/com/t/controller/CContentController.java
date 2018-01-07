package com.t.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.commom.pojo.EasyUIDataResult;
import com.project.commom.pojo.TreeNode;
import com.project.commom.utils.TResult;
import com.t.pojo.TContent;
import com.t.service.IContentCategoryService;
import com.t.service.IContentService;

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
	
	@Autowired
	private IContentCategoryService iContentCategoryService;
	
	/**
	 * 
	 * <p>Title: geTreeNodes</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 */
	@RequestMapping("/category/list")
	@ResponseBody
	public List<TreeNode> geTreeNodes(@RequestParam(value="id", required=true, defaultValue="0")Long id) {
		Map<String, Object> map = new HashMap<>();
		map.put("parentId", id);
		List<TreeNode> treeNodes = iContentCategoryService.getContentCategoryTreeNodes(map);
		return treeNodes;
	}
	
	@ResponseBody
	@RequestMapping("/query/list")
	public EasyUIDataResult getContentList(Integer page, Integer rows, Integer categoryId) {
		Map<String, Object> map = new HashMap<>();
		map.put("categoryId", categoryId);
		map.put("page", page);
		map.put("rows", rows);
		EasyUIDataResult contentList = iContentService.getContentList(map);
		return contentList;
	}
	
	/**
	 * 商品类别添加
	 * <p>Title: insertCategoryItem</p>
	 * <p>Description: </p>
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping("/category/create")
	@ResponseBody
	public TResult insertCategoryItem(Long parentId, String name){
		TResult result = iContentCategoryService.insertContentCategory(parentId, name);
		return result;
	}
	
	/**
	 * 添加商品
	 * <p>Title: insertContent</p>
	 * <p>Description: </p>
	 * @param tContent
	 * @return
	 */
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	@ResponseBody
	public TResult insertContent(TContent tContent) {
		return iContentService.insertContent(tContent);
	}
	
}
