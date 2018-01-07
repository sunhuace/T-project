package com.t.service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.commom.pojo.EasyUIDataResult;
import com.project.commom.utils.TResult;
import com.t.dao.TItemParamMapper;
import com.t.pojo.TItemParam;
import com.t.service.IItemParamService;

/**
 * 商品类别对应的 类别模板Service
 * <p>Title: IItemParamServiceImpl</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月13日下午10:10:34
 * @version 1.0
 */
@Service("iItemParamService")
public class IItemParamServiceImpl implements IItemParamService {
	
	@Autowired
	private TItemParamMapper tItemParamMapper;

	@Override
	public EasyUIDataResult getItemParamList(Map<String, Object> map) {
		//使用分页小助手
		PageHelper.startPage((Integer)map.get("page"), (Integer)map.get("rows"));
		List<TItemParam> tItemParamList = tItemParamMapper.getTItemParamList(map);
		//获得先详细的分页信息
		PageInfo<TItemParam> pageInfo = new PageInfo<>(tItemParamList);
		EasyUIDataResult easyUIDataResult = new EasyUIDataResult(pageInfo.getTotal(), tItemParamList);
		return easyUIDataResult;
	}

	@Override
	public TResult getItemParam(long itemCatId) {
		Map<String, Object> map = new HashMap<>();
		map.put("itemCatId", itemCatId);
		List<TItemParam> tItemParamList = tItemParamMapper.getTItemParamList(map);
		//如果有数据 则返回状态码 和 查询数据
		if(tItemParamList != null && tItemParamList.size() > 0) {
			return TResult.ok(tItemParamList.get(0));
		}
		//直接赶回状态吗
		return TResult.ok();
	}

	@Override
	public TResult insertItemParam(long cid, String paramData) {
		TItemParam tItemParam = new TItemParam();
		tItemParam.setItemCatId(cid);
		tItemParam.setParamData(paramData);
		tItemParam.setCreated(new Date());
		tItemParam.setUpdated(new Date());
		//向数据库中添加商品类别模板
		tItemParamMapper.insert(tItemParam);
		return TResult.ok();
	}
}
