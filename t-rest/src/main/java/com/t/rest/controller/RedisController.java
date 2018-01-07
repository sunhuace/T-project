package com.t.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.commom.utils.TResult;
import com.t.rest.service.RedisService;

@Controller
@RequestMapping("/cache/sync")
public class RedisController {

	@Autowired
	private RedisService redisService;
	
	@RequestMapping("/content/{contentCid}")
	@ResponseBody
	public TResult contentCacheSync(@PathVariable Long contentCid) {
		Map<String, Object> map = new HashMap<>();
		map.put("contentCId", contentCid);
		TResult result = redisService.syncContent(map);
		return result;
	}

}
