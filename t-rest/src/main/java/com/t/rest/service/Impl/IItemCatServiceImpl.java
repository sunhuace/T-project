package com.t.rest.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.commom.utils.JsonUtils;
import com.project.commom.utils.TResult;
import com.t.dao.TItemCatMapper;
import com.t.pojo.TContent;
import com.t.pojo.TItemCat;
import com.t.rest.dao.JedisClient;
import com.t.rest.pojo.ItemCat;
import com.t.rest.pojo.ItemCatResult;
import com.t.rest.service.IItemCatService;

/**
 * 商品类目导航Service
 * <p>
 * Title: IItemCatServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author sunhuace
 * @date 2016年11月13日下午2:43:56
 * @version 1.0
 */
@Service("iItemCatService")
public class IItemCatServiceImpl implements IItemCatService {

	@Autowired
	private TItemCatMapper tItemCatMapper;

	@Autowired
	private JedisClient jedisClient;

	@Value("${INDEX_CONTENTITEM_REDIS_KEY}")
	private String INDEX_CONTENTITEM_REDIS_KEY;

	/**
	 * 查询所有的ItemCate(商品类目列表) 返回为封装的数据
	 * <p>
	 * Title: queryAllItemCate
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public String queryAllItemCate() throws Exception {
		try {
			String result = jedisClient.get(INDEX_CONTENTITEM_REDIS_KEY);
			if (!StringUtils.isBlank(result)) {
				// 把字符串转换成list
				List<Object> objectsList = JsonUtils.getFiledToList(jedisClient.get(INDEX_CONTENTITEM_REDIS_KEY),
						"data");
				ItemCatResult itemCatResult = new ItemCatResult();
				itemCatResult.setData(objectsList);
				return JsonUtils.objectToJson(itemCatResult);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ItemCatResult itemCatResult = new ItemCatResult();
		itemCatResult.setData(getItemCateList(0));
		String jsonResult = JsonUtils.objectToJson(itemCatResult);
		try {
			jedisClient.set(INDEX_CONTENTITEM_REDIS_KEY, jsonResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonResult;
	}

	/**
	 * 递归循环出商品类别信息
	 * <p>
	 * Title: getItemCateList
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param parentId
	 * @return
	 */
	private List<?> getItemCateList(long parentId) {
		Map<String, Object> map = new HashMap<>();
		map.put("parentId", parentId);
		List<TItemCat> tItemCatsList = tItemCatMapper.getTItemCats2(map);
		List dateList = new ArrayList();
		int count = 0;// 计数使用 只显示14个列表 这样写是有问题的？？？ 是每一层都显示为14个
		for (TItemCat tItemCat : tItemCatsList) {
			count++;
			// 判断是否为父节点
			if (tItemCat.getIsParent()) {
				ItemCat itemCat = new ItemCat();
				itemCat.setUrl("/categoty/" + tItemCat.getId() + ".html ");
				itemCat.setName(tItemCat.getName());
				itemCat.setItem(getItemCateList(tItemCat.getId()));
				dateList.add(itemCat);
			} else {
				String catItem = "/item/" + tItemCat.getId() + ".html" + "|" + tItemCat.getName();
				dateList.add(catItem);
			}
			if (count == 14) {
				break;
			}
		}
		return dateList;
	}

}
