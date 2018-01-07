package com.t.rest.service;

import java.util.Map;

import com.project.commom.utils.TResult;

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
	 * 根据类别ID返回商品内容列表
	 * <p>Title: getContentListByCategory</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	TResult getContentListByCategory(Map<String, Object> map) throws Exception;
}
