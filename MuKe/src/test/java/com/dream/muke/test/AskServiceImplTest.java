package com.dream.muke.test;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dream.muke.entity.BackAskBean;
import com.dream.muke.service.AskService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AskServiceImplTest {
	@Autowired
	private AskService askService;

	@Test
	public void testGetAskInfo() {
		BackAskBean b=new BackAskBean();
		b.setPage(1);
		b.setRows(10);
		System.out.println(askService.getAskInfo(b));
	}
	
	@Test
	public void testFindCommunityAsks(){
		BackAskBean b=new BackAskBean();
		b.setPage(1);
		b.setRows(10);
		LogManager.getLogger().debug(askService.findCommunityAsks(b));
	}
	
	@Test
	public void testFindCommunityHotAsk(){
		LogManager.getLogger().debug(askService.findCommunityHotAsk());
	}
	
	@Test
	public void testFindCommunityHotUser(){
		LogManager.getLogger().debug(askService.findCommunityHotUser());
	}
	
	@Test
	public void testFindAskBeanByNo(){
		LogManager.getLogger().debug(askService.findAskBeanByNo("1061"));
	}
}
