package com.rest.test;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.t.dao.TItemCatMapper;
import com.t.dao.TItemMapper;
import com.t.dao.TItemParamMapper;
import com.t.pojo.TItem;
import com.t.pojo.TItemCat;
import com.t.pojo.TItemParam;
import com.t.rest.controller.CItemCatController;
import com.t.rest.service.IItemCatService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/spring-main.xml","/spring-mvc.xml"})
public class Main {
	
	@Autowired
	private IItemCatService iItemCatService;
	
	@Test
	public void testMappler() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-mian.xml");
		TItemMapper tItemMapper = applicationContext.getBean(TItemMapper.class);//获得代理对象
		PageHelper.startPage(1, 10);
		Map<String, Object> map = new HashMap<>();
		map.put("price", 1100);
		List<TItem> itemList = tItemMapper.getTItemList(map);
		for (Iterator it = itemList.iterator(); it.hasNext();) {
			TItem tItem = (TItem) it.next();
			System.out.println(tItem.getTitle());
		}
		PageInfo<TItem> pageInfo = new PageInfo<>(itemList);
		long total = pageInfo.getTotal();
		System.out.println(total);
	}
	
	@Test
	public void testItemCat() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/spring-main.xml");
		TItemCatMapper TItemCatMapper = applicationContext.getBean(TItemCatMapper.class);//获得代理对象
		List<TItemCat> geTItemCats = TItemCatMapper.getTItemCats(0);
		System.out.println(geTItemCats);
	}
	
	@Test
	public void testItemCat2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-mian.xml");
		TItemCatMapper TItemCatMapper = applicationContext.getBean(TItemCatMapper.class);//获得代理对象
		Map<String, Object> map = new HashMap<>();
		map.put("id", "1");
		List<TItemCat> geTItemCats = TItemCatMapper.getTItemCats2(map);
		System.out.println(geTItemCats);
	}
	
	
	@Test
	public void testItemParam() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-mian.xml");
		TItemParamMapper tItemParamMapper = applicationContext.getBean(TItemParamMapper.class);//获得代理对象
		Map<String, Object> map = new HashMap<>();
		map.put("itemCatId", 560);
		List<TItemParam> tItemParamList = tItemParamMapper.getTItemParamList(map);
		System.out.println(tItemParamList);
	}
	
	@Test
	public void testIItemCatService() throws Exception {
		System.out.println(iItemCatService.queryAllItemCate());
	}
	
	@Autowired
	private CItemCatController cItemCatController;
	
}
