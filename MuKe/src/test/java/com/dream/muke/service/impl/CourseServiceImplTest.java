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

import com.dream.muke.entity.CourseBean;
import com.dream.muke.mapper.CourseMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CourseServiceImplTest {
	@Autowired
	private CourseMapper cm;
	Map<String,Object> map= new HashMap<String,Object>();
	@Test
	public void testFindCourseByInfo() {
		map.put("cName", "j");
		map.put("ctNo","1000");
		List<CourseBean> list = cm.getCourseByInfo(map);
		System.out.println(list);
		assertNotNull(list);
	}

}
