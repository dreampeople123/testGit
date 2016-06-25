package com.dream.muke.test;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dream.muke.service.DeeplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class DeeplyServiceImplTest {
	@Autowired
	private DeeplyService deeplyService;

	@Test
	public void testGetDeeply() {
		LogManager.getLogger().debug(deeplyService.getDeeply());
	}

}
