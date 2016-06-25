package com.dream.muke.test;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dream.muke.entity.NewCourseUploadBean;
import com.dream.muke.entity.UploadChapterBean;
import com.dream.muke.service.CourseService;
import com.dream.muke.utils.DateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CourseServiceImplTest {
	@Autowired
	private CourseService courseService;

	@Test
	public void testUploadCourse() {
		NewCourseUploadBean course=new NewCourseUploadBean();
		course.setcName("test1");
		course.setdNo("1000");
		course.setCtNo("1000");
		course.setcUpdatetime(new DateUtil().getDate());
		course.setPicPath("G:");
		course.setcProfiles("简介");
		
		String videoPath="G:";
		String chName="chtest1";
		
		int result=courseService.uploadCourse(course, videoPath, chName,"1020");
		
		assertEquals("操作失败",1,result);
	}
	
	@Test
	public void testUploadChapter(){
		UploadChapterBean chapter=new UploadChapterBean("test","1000","dd",0,"1020");
		int result=courseService.uploadChapter(chapter);
		assertEquals("操作失败",1,result);
	}
	
	@Test
	public void testFindCommunityHotCourse(){
		LogManager.getLogger().debug(courseService.findCommunityHotCourse());
	}
}
