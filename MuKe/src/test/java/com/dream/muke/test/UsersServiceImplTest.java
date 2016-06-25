package com.dream.muke.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dream.muke.entity.Course;
import com.dream.muke.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UsersServiceImplTest {
	@Autowired
	private UsersService usersService;

	@Test
	public void testGetTeacherCourse() {
		List<Course> courses=usersService.getTeacherCourse("1020");
		LogManager.getLogger().debug(courses);
		
		assertNotNull("操作失败",courses);
	}

}
