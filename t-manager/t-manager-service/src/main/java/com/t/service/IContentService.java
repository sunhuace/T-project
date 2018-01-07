package com.t.service;

import java.util.Map;

import com.project.commom.pojo.EasyUIDataResult;
import com.project.commom.utils.TResult;
import com.t.pojo.TContent;

/**
 * 商品内容管理Service
 * <p>Title: CContentService</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月13日下午10:47:17
 * @version 1.0
 */
public interface IContentService {
	
	
	/**
	 * 分页显示商品内容列表
	 * <p>Title: getContentList</p>
	 * <p>Description: </p>
	 * @param map
	 * @return
	 */
	EasyUIDataResult getContentList(Map<String, Object> map);
	
	/**
	 * 添加商品
	 * <p>Title: insertContent</p>
	 * <p>Description: </p>
	 * @param tContent
	 * @return
	 */
	TResult insertContent(TContent tContent);
	
}
