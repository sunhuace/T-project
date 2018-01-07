package com.t.service;

import java.util.Map;

import com.project.commom.pojo.EasyUIDataResult;
import com.project.commom.utils.TResult;

/**
 * 商品类别对应的规格模板Service
 * <p>Title: IItemParamService</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月6日下午3:19:52
 * @version 1.0
 */
public interface IItemParamService {
	
	/**
	 * 根据条件获得规格参数模板的所有列表
	 * <p>Title: getItemParamList</p>
	 * <p>Description: </p>
	 * @param map
	 * @return EasyUIDataResult
	 */
	EasyUIDataResult getItemParamList(Map<String, Object> map);
	
	/**
	 * 根据产品产品类别ID 查询 该类别下的规格规格模板
	 * <p>Title: getItemParam</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @return
	 */
	TResult getItemParam(long itemCatId);
	
	/**
	 * 插入对应的商品类别cid 对应的模板
	 * <p>Title: insertItemParam</p>
	 * <p>Description: </p>
	 * @param cid
	 * @param paramData
	 * @return
	 */
	TResult insertItemParam(long cid, String paramData);

}
