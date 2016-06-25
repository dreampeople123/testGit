package com.dream.muke.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.Course;
import com.dream.muke.service.CourseService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("courseAction")
public class CourseAction implements ModelDriven<Course>{
	private Course course;
	private List<Course> courses;
	@Autowired
	private CourseService courseService;
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String findCourseNameAndId(){
		courses = courseService.findCourseNameAndId();
		return "findCourseNameAndId";
	}

	@Override
	public Course getModel() {
		course = new Course();
		return course;
	}
}
