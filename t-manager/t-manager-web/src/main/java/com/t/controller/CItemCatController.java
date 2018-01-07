package com.t.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.commom.pojo.EasyUIDataResult;
import com.project.commom.pojo.TreeNode;
import com.t.service.IItemCatService;

/**
 * 商品类别管理的Controller
 * <p>Title: CItemCatController</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月3日下午5:34:59
 * @version 1.0
 */
@Controller("cItemCatController")
@RequestMapping("/item/cat")
public class CItemCatController {
	
	@Autowired
	private IItemCatService iItemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<TreeNode> getItemCatList(@RequestParam(value="id", required=true, defaultValue="0") Long parentId) {
		List<TreeNode> itemCatList = iItemCatService.getItemCatList(parentId);
		return itemCatList;
	}
	
	@RequestMapping("/listCategory")
	@ResponseBody
	public EasyUIDataResult getContentList(Integer page, Integer rows) {
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("rows", rows);
		return iItemCatService.getItemCatList3(map);
	}
}
