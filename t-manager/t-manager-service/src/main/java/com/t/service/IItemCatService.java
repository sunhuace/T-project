package com.t.service;

import java.util.List;
import java.util.Map;

import com.project.commom.pojo.EasyUIDataResult;
import com.project.commom.pojo.TreeNode;
import com.t.pojo.TItemCat;

public interface IItemCatService {
	
	/**
	 * 根据parentID返回商品类别选择的树形结构数据
	 * <p>Title: getItemCatList</p>
	 * <p>Description: </p>
	 * @param parentId
	 * @return
	 */
	List<TreeNode> getItemCatList(long parentId);
	
	
	/**
	 * 根据父类ID 值获得上商品类别对应的产品类别
	 * <p>Title: getItemCatList</p>
	 * <p>Description: </p>
	 * @param parentId
	 * @return
	 */
	List<TItemCat> getItemCatList2(Map<String, Object> map);
	
	

	/**
	 * 分页查询出商品的类别信息 返回对应的EasyUI封装好的数据格式
	 * <p>Title: getItemCatList</p>
	 * <p>Description: </p>
	 * @param parentId
	 * @return
	 */
	EasyUIDataResult getItemCatList3(Map<String, Object> map);
}
