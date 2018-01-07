package com.t.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * <p>Title: PageController</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月2日下午10:41:51
 * @version 1.0
 */
@Controller("cpageController")
public class CPageController {
	
	/**
	 * 请求首页
	 * <p>Title: showIndex</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	/**
	 * 请求点击页面
	 * <p>Title: showPage</p>
	 * <p>Description: </p>
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable(value="page") String page) {
		return page;
	}
}
