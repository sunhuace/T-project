package com.t.portal.service;

/**
 * 首页大广告位Service
 * <p>Title: ADService</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月14日下午11:24:45
 * @version 1.0
 */
public interface AdService {
	
	/**
	 * 获得广告位的JSON数据格式 图片 使用HTTPClient 解决跨域请求问题
	 * <p>Title: getAdItemList</p>
	 * <p>Description: </p>
	 * @return
	 */
	String getAdItemList() throws Exception;
}
