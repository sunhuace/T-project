package com.t.service;

import java.util.Map;

/**
 * 商品规格参数详细信息Service
 * <p>Title: IItemParamItemService</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月7日下午3:26:04
 * @version 1.0
 */
public interface IItemParamItemService {
	
	/**
	 * 根据商品ID返回商品规格相信信息的HTML页面表示
	 * <p>Title: getItemPatamItem</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @return
	 */
	String getItemPatamItem(Map<String, Object> map);
}
