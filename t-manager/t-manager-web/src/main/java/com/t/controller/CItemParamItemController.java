package com.t.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.t.service.IItemParamItemService;

/**
 * 商品规格参数详细信息Controller 
 * <p>Title: CItemParamItemController</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月7日下午4:08:48
 * @version 1.0
 */
@Controller("cItemParamItemController")
@RequestMapping("item/param/item")
public class CItemParamItemController {
	
	@Autowired
	private IItemParamItemService iItemParamItemService;
	
	/**
	 * 根据商品ID返回商品规格参数的详细信息并渲染在视图中
	 * <p>Title: getItemParamItem</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @param model
	 * @return
	 */
	@RequestMapping("/{itemId}")
	public String getItemParamItem(@PathVariable String itemId, Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item_id", itemId);
		String itemPatamItem = iItemParamItemService.getItemPatamItem(map);
		model.addAttribute("itemParamData", itemPatamItem);
		return "item-param-show";
	}
}
