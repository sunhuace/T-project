package com.t.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.t.portal.service.AdService;

@Controller("pageController")
public class PageController {
	
	@Autowired
	private AdService adService;

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String ShowIndex(Model model) throws Exception {
		String adResult = adService.getAdItemList();
		model.addAttribute("ad1", adResult);
		return "index";
	}
}
