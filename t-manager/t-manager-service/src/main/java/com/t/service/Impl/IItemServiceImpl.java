package com.t.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.commom.pojo.EasyUIDataResult;
import com.project.commom.utils.IDUtils;
import com.project.commom.utils.TResult;
import com.t.dao.TItemDescMapper;
import com.t.dao.TItemMapper;
import com.t.dao.TItemParamItemMapper;
import com.t.pojo.TItem;
import com.t.pojo.TItemDesc;
import com.t.pojo.TItemParamItem;
import com.t.service.IItemService;

/**
 * 内容管理Service
 * <p>Title: IItemServiceImpl</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月13日下午10:09:11
 * @version 1.0
 */
@Service("iItemService")
public class IItemServiceImpl implements IItemService {

	@Autowired
	private TItemMapper itemMapper;
	
	@Autowired
	private TItemDescMapper tItemDescMapper;

	@Autowired
	private TItemParamItemMapper tItemParamItemMapper;
	
	@Override
	public TItem getItemById(long itemId) {
		return itemMapper.selectByPrimaryKey(itemId);
	}

	@Override
	public EasyUIDataResult getItemList(Map<String, Object> map) {
		//使用分页小助手
		PageHelper.startPage((Integer)map.get("page"), (Integer) map.get("rows"));
		List<TItem> tItemList = itemMapper.getTItemList(map);
		//在分页小助手中获得总的记录数
		PageInfo<TItem> pageInfo = new PageInfo<>(tItemList);
		long total = pageInfo.getTotal();
		//使用common pojo 组装easyUI 需要的数据格式
		EasyUIDataResult result = new EasyUIDataResult(total, tItemList);
		return result;
	}

	@Override
	public TResult createItem(TItem tItem, String itemDesc, String itemParamsItem) throws Exception  {
		//生成商品ID 
		Long itemId = IDUtils.genItemId();
		tItem.setId(itemId);
		//设置商品的状态 为可以出售状态
		tItem.setStatus((byte)1);
		tItem.setCreated(new Date());
		tItem.setUpdated(new Date());
		itemMapper.insertSelective(tItem);
		//添加商品描述信息
		TResult tResult = insertItemDesc(itemId, itemDesc);
		if(tResult.getStatus() != 200) {
			throw new Exception();//抛出异常 进行回滚操作
		}
		//添加商品的规格描述的详细信息
		tResult = insetItemParamItem(itemId, itemParamsItem);
		if(tResult.getStatus() != 200) {
			throw new Exception();//抛出异常 进行回滚操作
		}
		return TResult.ok();
	}
	
	/**
	 * 添加商品描述信息
	 * <p>Title: insertItemDesc</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @param itemDesc
	 * @return
	 */
	private TResult insertItemDesc(Long itemId, String itemDesc) {
		TItemDesc tItemDesc = new TItemDesc();
		tItemDesc.setItemId(itemId);
		tItemDesc.setItemDesc(itemDesc);
		tItemDesc.setCreated(new Date());
		tItemDesc.setUpdated(new Date());
		tItemDescMapper.insertSelective(tItemDesc);
		return TResult.ok();
	} 

	/**
	 * 添加商品的规格详细信息
	 * <p>Title: insetItemParamItem</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @param itemParamsItem
	 * @return
	 */
	private TResult insetItemParamItem(Long itemId, String itemParamsItem) {
		TItemParamItem tItemParamItem = new TItemParamItem();
		tItemParamItem.setItemId(itemId);
		tItemParamItem.setParamData(itemParamsItem);
		tItemParamItem.setCreated(new Date());
		tItemParamItem.setUpdated(new Date());
		tItemParamItemMapper.insertSelective(tItemParamItem);
		return TResult.ok();
	}
	
}
