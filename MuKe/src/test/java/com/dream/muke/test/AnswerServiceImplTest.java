package com.dream.muke.test;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dream.muke.service.AnswerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AnswerServiceImplTest {
	@Autowired
	private AnswerService answerService;

	@Test
	public void testGetAskAnswerByNo() {
		System.out.println(answerService.getAskAnswerByNo("1002"));
	}
	
	@Test
	public void testAddAnswer() {
		LogManager.getLogger().debug(answerService.addAnswer("1040", "1040", "测试回答内容", ""));
	}
}
