package com.t.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.commom.pojo.TreeNode;
import com.project.commom.utils.TResult;
import com.t.dao.TContentCategoryMapper;
import com.t.pojo.TContentCategory;
import com.t.service.IContentCategoryService;

/**
 * 商品内容类别管理Service
 * <p>Title: IContentCategoryService</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月14日下午9:24:36
 * @version 1.0
 */
@Service("iContentCategoryService")
public class IContentCategoryServiceImpl implements IContentCategoryService {

	@Autowired
	private TContentCategoryMapper tContentCategoryMapper;

	@Override
	public List<TreeNode> getContentCategoryTreeNodes(Map<String, Object> map) {
		List<TContentCategory> tContentCategoryList = tContentCategoryMapper.getTContentCategoryList(map);
		List<TreeNode> tList = new ArrayList<>();
		for (TContentCategory tContentCategory : tContentCategoryList) {
			TreeNode tNode = new TreeNode(tContentCategory.getId(), tContentCategory.getName(),
					tContentCategory.getIsParent() ? "closed" : "open");
			tList.add(tNode);
		}
		return tList;
	}

	@Override
	public TResult insertContentCategory(long parentId, String name) {
		TContentCategory tContentCategory = new TContentCategory();
		tContentCategory.setIsParent(false);
		tContentCategory.setCreated(new Date());
		tContentCategory.setUpdated(new Date());
		tContentCategory.setStatus(1);//1 正常
		tContentCategory.setName(name);
		tContentCategory.setParentId(parentId);
		tContentCategory.setSortOrder(1);
		//插入节点返回主键
		tContentCategoryMapper.insert(tContentCategory);
		//获取父亲节点
		TContentCategory tContentCategory2 = tContentCategoryMapper.selectByPrimaryKey(parentId);
		if(!tContentCategory2.getIsParent()) {
			tContentCategory2.setIsParent(true);
			tContentCategoryMapper.updateByPrimaryKey(tContentCategory2);//更新父亲节点
		}
		//返回插入的节点
		return TResult.ok(tContentCategory);
	}

}
