package com.t.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.commom.pojo.EasyUIDataResult;
import com.project.commom.utils.TResult;
import com.t.pojo.TItem;
import com.t.service.IItemService;

/**
 * 商品管理的Controller
 * <p>Title: CItemController</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月2日下午9:48:25
 * @version 1.0
 */
@Controller("cItemController")
public class CItemController {
	
	@Autowired
	private IItemService iItemService;
	
	/**
	 * 根据商品ID查询相应商品信息
	 * <p>Title: geTItemById</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @return TItem
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TItem geTItemById(@PathVariable(value="itemId") Long itemId) {
		TItem item = iItemService.getItemById(itemId);
		return item;
	}
	
	/**
	 * 分页展示商品内容列表
	 * <p>Title: getItemList</p>
	 * <p>Description: </p>
	 * @param page
	 * @param rows
	 * @return EasyUIDataResult
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataResult getItemList(@RequestParam(value="page", required=false) Integer page, 
			@RequestParam(value="rows", required=false) Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("rows", rows);
		EasyUIDataResult result = iItemService.getItemList(map);
		return result;
	}
	
	/**
	 * 添加商品 包括添的描述信息 商品类别模板的填写信息
	 * <p>Title: createItem</p>
	 * <p>Description: </p>
	 * @param tItem
	 * @param desc
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	public TResult createItem(TItem tItem, String desc, String itemParamsItem) throws Exception{
		TResult tResult = iItemService.createItem(tItem, desc, itemParamsItem);
		return tResult;
	}
	
}
