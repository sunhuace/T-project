package com.t.service;

import java.util.List;
import java.util.Map;

import com.project.commom.pojo.TreeNode;
import com.project.commom.utils.TResult;

/**
 * 商品内容类别管理Service
 * <p>Title: IContentCategoryService</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月14日下午9:24:36
 * @version 1.0
 */
public interface IContentCategoryService {

	
	/**
	 * 根据当前ID获得该ID下的所有节点 封装成TreeNode对应的格式 map 中传入当前的 
	 * <p>Title: getTreeNodes</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 */
	List<TreeNode> getContentCategoryTreeNodes(Map<String, Object> map);
	
	/**
	 * 根据父类ID 和该节点的名称 插入一个节点 返回带有插入节点的TResult
	 * <p>Title: insertContentCategory</p>
	 * <p>Description: </p>
	 * @param parentId
	 * @param name
	 * @return
	 */
	TResult insertContentCategory(long parentId, String name);
}
