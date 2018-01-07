package com.t.rest.service.Impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.commom.utils.JsonUtils;
import com.project.commom.utils.TResult;
import com.t.dao.TContentMapper;
import com.t.pojo.TContent;
import com.t.rest.dao.JedisClient;
import com.t.rest.service.IContentService;

/**
 * 商品内容管理Service
 * <p>
 * Title: CContentService
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author sunhuace
 * @date 2016年11月13日下午10:47:17
 * @version 1.0
 */
@Service("iContentService")
public class IContentServiceImpl implements IContentService {

	@Autowired
	private TContentMapper tContentMapper;

	@Autowired
	private JedisClient jedisClient;

	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;

	@Override
	public TResult getContentListByCategory(Map<String, Object> map) throws Exception {
		// 从缓存中取内容
		try {
			String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, map.get("categoryId") + "");
			if (!StringUtils.isBlank(result)) {
				// 把字符串转换成list
				List<TContent> resultList = JsonUtils.jsonToList(result, TContent.class);
				return TResult.ok(resultList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<TContent> list = tContentMapper.getContentsList(map);
		// 向缓存中添加内容
		try {
			// 把list转换成字符串
			String cacheString = JsonUtils.objectToJson(list);
			jedisClient.hset(INDEX_CONTENT_REDIS_KEY, map.get("categoryId") + "", cacheString);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return TResult.ok(list);
	}

}
