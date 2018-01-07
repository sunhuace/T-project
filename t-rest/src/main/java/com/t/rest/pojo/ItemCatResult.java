package com.t.rest.pojo;

import java.util.List;

/**
 * 商品类目导航结果 组装数据
 * <p>Title: ItemCatResult</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月13日下午2:41:14
 * @version 1.0
 */
public class ItemCatResult {
	
	private List<?> data;

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ItemCatResult [data=" + data + "]";
	}
	
}
