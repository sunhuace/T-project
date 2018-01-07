package com.t.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.commom.pojo.EasyUIDataResult;
import com.project.commom.utils.TResult;
import com.t.service.IItemParamService;

/**
 * 商品类别对应的规格模板Controller
 * <p>Title: CItemParamController</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月6日下午3:31:01
 * @version 1.0
 */
@Controller
@RequestMapping("/item/param")
public class CItemParamController {
	
	@Autowired
	private IItemParamService iItemParamService;
	
	/**
	 * 分页展示商品类别列表
	 * <p>Title: getItemParamList</p>
	 * <p>Description: </p>
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataResult getItemParamList(Integer page, Integer rows) {
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("rows", rows);
		EasyUIDataResult itemParamList = iItemParamService.getItemParamList(map);
		return itemParamList;
	}
	
	/**
	 * 根据商品的类别ID 查询给类别是否存在对应的类别模板 如果存在 则返回状态吗和对应的数据  否则返回状态吗
	 * <p>Title: getItemParam</p>
	 * <p>Description: </p>
	 * @param itemCatId
	 * @return
	 */
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public TResult getItemParam(@PathVariable Long itemCatId) {
		return iItemParamService.getItemParam(itemCatId);
	}
	
	/**
	 * 插入对应的商品类别cid 对应的模板
	 * <p>Title: insertItemParam</p>
	 * <p>Description: </p>
	 * @param cid
	 * @param paramData
	 * @return
	 */
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TResult insertItemParam(@PathVariable Long cid, String paramData) {
		TResult result = iItemParamService.insertItemParam(cid, paramData);
		return result;
	}
	
}
