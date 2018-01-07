package com.t.rest.service;

import java.util.Map;

import com.project.commom.utils.TResult;

/**
 * Redis 同步缓存
 * <p>Title: RedisService</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月26日下午9:26:48
 * @version 1.0
 */
public interface RedisService {
	/**
	 * 输入内容ID同步缓存
	 * <p>Title: syncContent</p>
	 * <p>Description: </p>
	 * @param map
	 * @return
	 */
	TResult syncContent(Map<String, Object> map);
}
