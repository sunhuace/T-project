package com.t.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.t.portal.service.AdService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring.xml" })
public class Main {
	
	@Autowired
	private AdService aDService;
	
	@Test
	public void testItem() throws Exception {
		aDService.getAdItemList();
	}
}