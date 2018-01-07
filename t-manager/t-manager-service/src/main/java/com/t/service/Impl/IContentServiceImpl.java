package com.t.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.commom.pojo.EasyUIDataResult;
import com.project.commom.utils.HttpClientUtil;
import com.project.commom.utils.TResult;
import com.t.dao.TContentMapper;
import com.t.pojo.TContent;
import com.t.service.IContentService;

/**
 * 商品内容管理Service
 * <p>Title: CContentService</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月13日下午10:47:17
 * @version 1.0
 */
@Service("iContentService")
public class IContentServiceImpl implements IContentService {

	@Autowired
	private TContentMapper tContentMapper;
	
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${REST_CONTENT_SYNC_URL}")
	private String REST_CONTENT_SYNC_URL;

	@Override
	public EasyUIDataResult getContentList(Map<String, Object> map) {
		PageHelper.startPage((Integer)map.get("page"), (Integer)map.get("rows"));
		List<TContent> geTContentsList = tContentMapper.getContentsList(map);
		PageInfo<TContent> pageInfo = new PageInfo<>(geTContentsList);
		long total = pageInfo.getTotal();
		EasyUIDataResult easyUIDataResult = new EasyUIDataResult(total, geTContentsList);
		return easyUIDataResult;
	}

	/**
	 * 添加商品
	 * <p>Title: insertContent</p>
	 * <p>Description: </p>
	 * @param tContent
	 * @return
	 */
	@Override
	public TResult insertContent(TContent tContent) {
		tContent.setUpdated(new Date());
		tContent.setCreated(new Date());
		tContentMapper.insert(tContent);
		try {
			HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + tContent.getCategoryId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TResult.ok();
	}

}
