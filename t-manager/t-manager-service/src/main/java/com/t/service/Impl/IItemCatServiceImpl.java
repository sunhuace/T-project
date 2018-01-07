package com.t.service.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.commom.pojo.EasyUIDataResult;
import com.project.commom.pojo.TreeNode;
import com.t.dao.TItemCatMapper;
import com.t.pojo.TItemCat;
import com.t.service.IItemCatService;

/**
 * 商品类别管理Service
 * <p>Title: IItemCatServiceImpl</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月13日下午10:04:35
 * @version 1.0
 */
@Service("itemCatService")
public class IItemCatServiceImpl implements IItemCatService {

	@Autowired
	private TItemCatMapper tItemCatMapper;

	@Override
	public List<TreeNode> getItemCatList(long parentId) {
		List<TItemCat> tItemList = tItemCatMapper.getTItemCats(parentId);
		List<TreeNode> treeNodes = new ArrayList<>();
		for (Iterator<TItemCat> it = tItemList.iterator(); it.hasNext();) {
			TItemCat tItemCat = (TItemCat) it.next();
			TreeNode treeNode = new TreeNode(tItemCat.getId(), tItemCat.getName(),
					tItemCat.getIsParent() ? "closed" : "open");
			treeNodes.add(treeNode);
		}
		return treeNodes;
	}

	@Override
	public List<TItemCat> getItemCatList2(Map<String, Object> map) {
		return tItemCatMapper.getTItemCats2(map);
	}

	@Override
	public EasyUIDataResult getItemCatList3(Map<String, Object> map) {
		//使用分页小助手
		PageHelper.startPage((Integer)map.get("page"), (Integer)map.get("rows"));
		List<TItemCat> tItemCats2 = tItemCatMapper.getTItemCats2(map);
		PageInfo<TItemCat> pageInfo = new PageInfo<>(tItemCats2);
		long total = pageInfo.getTotal();
		EasyUIDataResult easyUIDataResult = new EasyUIDataResult(total, tItemCats2);
		return easyUIDataResult;
	}

}
