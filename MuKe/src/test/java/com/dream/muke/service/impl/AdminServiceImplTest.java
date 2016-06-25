package com.dream.muke.service.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dream.muke.entity.Admin;
import com.dream.muke.entity.CommentBean;
import com.dream.muke.entity.CourseBean;
import com.dream.muke.entity.UCourseBean;
import com.dream.muke.entity.UsersBean;
import com.dream.muke.entity.frontAsk;
import com.dream.muke.service.AdminService;
import com.dream.muke.service.AskService;
import com.dream.muke.service.ChapterService;
import com.dream.muke.service.CommentService;
import com.dream.muke.service.CourseService;
import com.dream.muke.service.UcourseService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AdminServiceImplTest {
	@Autowired
	private AdminService adminService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private UcourseService ucourseService;
	@Autowired
	private ChapterService chapterService;

	@Autowired
	private AskService askService;
	@Test
	public void testAddAdmin() {
		Admin ads=new Admin();
		ads.setaName("d");
		ads.setaPwd("d");
		int res=adminService.addAdmin(ads);
		System.out.println("结果是"+res);
	}
	@Test
	public void testUpdateAdmin() {
		Admin ads=new Admin();
		ads.setaId("1004");
		ads.setaName("e");
		ads.setaPwd("b");
		int res=adminService.updateAdmin(ads);
		System.out.println("结果是"+res);
	}
	@Test
	public void testDelAdmin() {
		int res=adminService.delAdmin("1004");
		System.out.println("结果是"+res);
	}
	@Test
	public void testsd() {
		CommentBean com=new CommentBean();//临时的来查询的CommentBean
		com.setChNo("1000");
		com.setPage(1);
		com.setRows(10);
		List<CommentBean> comments=commentService.findCommentsByInfo(com); //获得评论信息
		System.out.println("结果是"+comments);
	}
	@Test
	public void testsdd() {
		CommentBean com=new CommentBean();//临时的来查询的CommentBean
		com.setChNo("1000");
		com.setPage(1);
		com.setRows(10);
		List<CommentBean> comments=commentService.findCommentByDian(com); //获得评论信息点赞排序
		System.out.println("结果是"+comments);
	}
	@Test
	public void testsdS() {
		Map<String,Object> map;
		map = new HashMap<String, Object>();
		map.put("cNo","1000");
		map.put("uNo","1000");
		map.put("chNo","1000");
		List<UsersBean> tongxue=ucourseService.findUsBychano(map);//查询这门课程有什么人在学 
		int counu=ucourseService.totalChapterno(map);//查询这门课程有多少人在学 
		System.out.println("结果是"+tongxue);
		System.out.println("结果counu是"+counu);
	}
	@Test
	public void testsdSs() {
		//测试查询课程
		CourseBean coure=(CourseBean) courseService.findBycno("1000").get(0);
		System.out.println("结果是"+coure);
	}
	@Test
	public void testsdSss() {
		Map<String, Object>  maps=new HashMap<String, Object>();
		maps.put("cNo", "1000");
		maps.put("ctNo","1000");
		//测试查询问题
		List<frontAsk> asks=askService.findForntAsk(maps);
		System.out.println("结果是"+asks);
	}
	@Test
	public void testsdss() {
		Map<String, Object>  maps=new HashMap<String, Object>();
		maps.put("cNo", "1000");
		maps.put("ctNo","1000");
		//测试查询精华问题
		List<frontAsk> asks=askService.findJinAskByCtype(maps);
		System.out.println("结果是"+asks);
	}
	@Test
	public void testsdSsss() {
		List<CourseBean> sameUcourse=ucourseService.sameByCno("1000");//查询学习这门课程的同学学习的其他课程

		System.out.println("结果是"+sameUcourse);
	}
	@Test
	public void testsdsdfs() {
		UCourseBean ucur=new UCourseBean();
		ucur.setcNo("1000");
		ucur.setuNo("1020");
		ucur.setPage("1");
		ucur.setRows("10");
		System.out.println("阿三"+ucur);
		UCourseBean daucourse=ucourseService.findUcourse(ucur).get(0);
		System.out.println(daucourse+"用户课程水电费水电费");
	}
}
