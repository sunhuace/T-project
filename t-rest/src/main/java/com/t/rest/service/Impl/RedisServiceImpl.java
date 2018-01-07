package com.t.rest.service.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.commom.utils.TResult;
import com.t.rest.dao.JedisClient;
import com.t.rest.service.RedisService;

/**
 * Redis 同步缓存
 * <p>Title: RedisService</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月26日下午9:26:48
 * @version 1.0
 */
@Service
public class RedisServiceImpl implements RedisService {
	
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	@Autowired
	private JedisClient jedisClient;

	/**
	 * 输入内容ID同步缓存
	 * <p>Title: syncContent</p>
	 * <p>Description: </p>
	 * @param map
	 * @return
	 */
	@Override
	public TResult syncContent(Map<String, Object> map) {
		try {
			jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, map.get("contentCId") + "");
		} catch (Exception e) {
			e.printStackTrace();
			return TResult.build(500, e.getMessage());
		}
		return TResult.ok();
	}

}
