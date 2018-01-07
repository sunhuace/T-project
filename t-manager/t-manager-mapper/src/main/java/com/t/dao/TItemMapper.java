package com.t.dao;

import java.util.List;
import java.util.Map;

import com.t.pojo.TItem;

public interface TItemMapper {
	
	int deleteByPrimaryKey(Long id);

	int insert(TItem record);

	int insertSelective(TItem record);

	TItem selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(TItem record);

	int updateByPrimaryKey(TItem record);
	
	/**
	 * 根据条件查询商品的List列表
	 * <p>Title: getTItemList</p>
	 * <p>Description: </p>
	 * @param map
	 * @return
	 */
	List<TItem> getTItemList(Map<String, Object> map);
}