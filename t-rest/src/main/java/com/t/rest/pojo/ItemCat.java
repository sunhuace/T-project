package com.t.rest.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 商品类目导航POJO
 * <p>Title: ItemCat</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月13日下午2:40:22
 * @version 1.0
 */
public class ItemCat {
	
	@JsonProperty("u")
	private String url;
	@JsonProperty("n")
	private String name;
	
	//使用泛型 不确定List中放入什么样的数据格式
	@JsonProperty("i")
	private List<?> item;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<?> getItem() {
		return item;
	}
	public void setItem(List<?> item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "ItemCat [url=" + url + ", name=" + name + ", item=" + item + "]";
	}
	
}
