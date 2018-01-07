package com.t.portal.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.commom.utils.HttpClientUtil;
import com.project.commom.utils.JsonUtils;
import com.project.commom.utils.TResult;
import com.t.pojo.TContent;
import com.t.portal.pojo.ADItem;
import com.t.portal.service.AdService;

/**
 * 首页大广告位Service
 * <p>Title: ADServiceImpl</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月14日下午11:41:17
 * @version 1.0
 */
@Service("aDService")
public class ADServiceImpl implements AdService {

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;

	@Value("${INDEX_AD1_URL}")
	private String INDEX_AD1_URL;

	@Override
	public String getAdItemList() throws Exception {
		// 调用服务层
		String result2 = HttpClientUtil.doGet(REST_BASE_URL + INDEX_AD1_URL);

		// 把json数据转换成对象
		TResult result = TResult.formatToList(result2, TContent.class);
		List<ADItem> itemList = new ArrayList<>();
		if (result.getStatus() == 200) {
			List<TContent> contentList = (List<TContent>) result.getData();
			for (TContent tbContent : contentList) {
				ADItem item = new ADItem();
				item.setHeight(240);
				item.setWidth(670);
				item.setSrc(tbContent.getPic());
				item.setHeightB(240);
				item.setWidthB(550);
				item.setSrcB(tbContent.getPic2());
				item.setAlt(tbContent.getTitleDesc());
				item.setHref(tbContent.getUrl());
				itemList.add(item);
			}

		}
		return JsonUtils.objectToJson(itemList);

	}

}
