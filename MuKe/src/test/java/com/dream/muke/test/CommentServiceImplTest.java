package com.dream.muke.test;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dream.muke.entity.CommentBean;
import com.dream.muke.service.CommentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CommentServiceImplTest {
	@Autowired
	private CommentService commentService;

	@Test
	public void testGetAllComment() {
		CommentBean commentBean=new CommentBean();
		commentBean.setPage(1);
		commentBean.setRows(10);		
		LogManager.getLogger().debug(commentService.getAllComment(commentBean));
	}

	@Test
	public void testGetCommentTotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindCommentsByInfo() {
		CommentBean commentBean=new CommentBean();
		commentBean.setChNo("1001");
		commentBean.setPage(1);
		commentBean.setRows(10);
		LogManager.getLogger().debug("操作结果为:"+commentService.findCommentsByInfo(commentBean));
		LogManager.getLogger().debug("操作结果为:"+commentService.getCommentTotal(commentBean));
	}
	
	@Test
	public void testDelComments(){
		String coNos="1000,1001";
		LogManager.getLogger().debug("操作结果为:"+commentService.delComments(coNos));
	}
}
