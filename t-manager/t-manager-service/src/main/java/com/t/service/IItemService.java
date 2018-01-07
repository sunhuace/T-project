package com.t.service;

import java.util.Map;

import com.project.commom.pojo.EasyUIDataResult;
import com.project.commom.utils.TResult;
import com.t.pojo.TItem;

public interface IItemService {
	
	/**
	 * 根据ID获得商品
	 * <p>Title: getItemById</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @return
	 */
	TItem getItemById(long itemId);
	
	/**
	 * 根据条件获得商品列表的总的数据
	 * <p>Title: getItemList</p>
	 * <p>Description: </p>
	 * @param map
	 * @return
	 */
	EasyUIDataResult getItemList(Map<String, Object> map);
	
	/**
	 * 添加商品 包括添加商品的描述 商品对应类模板的规格信息
	 * <p>Title: createItem</p>
	 * <p>Description: </p>
	 * @param tItem
	 * @return
	 * @throws Exception 
	 */
	TResult createItem(TItem tItem, String itemDesc, String itemParamsItem) throws Exception;
}
