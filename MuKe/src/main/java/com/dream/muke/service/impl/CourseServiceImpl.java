package com.dream.muke.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dream.muke.entity.CommunityHotCourseBean;
import com.dream.muke.entity.NewCourseUploadBean;
import com.dream.muke.entity.UploadChapterBean;
import com.dream.muke.mapper.ChapterMapper;
import com.dream.muke.mapper.CourseMapper;
import com.dream.muke.mapper.UsersMapper;
import com.dream.muke.service.CourseService;

import java.util.List;
import java.util.Map;

import com.dream.muke.entity.Course;
import com.dream.muke.entity.CourseBean;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private ChapterMapper chapterMapper;
	@Autowired
	private UsersMapper usersMapper;
	
	@Transactional
	public int uploadCourse(NewCourseUploadBean course, String videoPath,String chName,String uno) {
		int r1,r2,r3;
		r1=addNewCourse(course);
		
		UploadChapterBean chapter=new UploadChapterBean(chName,course.getCno(),videoPath,0,uno);
		r2=addNewChapter(chapter);
		r3=addTeacherCourse(chapter);
		
		if(r1>0 && r2>0 && r3>0){
			return 1;
		}
		return 0;
	}
	
	/**
	 * 添加新课程
	 * @param course
	 * @return
	 */
	@Transactional
	public int addNewCourse(NewCourseUploadBean course){
		return courseMapper.addNewCourse(course);
	}
	
	/**
	 * 添加新章节
	 * @param params
	 * @return
	 */
	@Transactional
	public int addNewChapter(UploadChapterBean chapter){
		return chapterMapper.addNewChapter(chapter);
	}
	
	/**
	 * 添加教师维护课程的信息
	 * @param chapter
	 * @return
	 */
	@Transactional
	public int addTeacherCourse(UploadChapterBean chapter){
		return usersMapper.addTeacherCourse(chapter);
	}
	
	public List<CommunityHotCourseBean> findCommunityHotCourse() {
		return courseMapper.findCommunityHotCourse();
	}

	public int uploadChapter(UploadChapterBean chapter) {
		return chapterMapper.addNewChapter(chapter);
	}
	
	@Override
	public List<Course> findCourseNameAndId() {
		return courseMapper.getCourseNameAndId();
	}
	@Override
	public List<CourseBean> findCourseInfo(Map<String, Object> map) {
		return courseMapper.getCourseInfo(map);
	}
	
	//按照课程名或课程类别编号查找课程信息
	@Override
	public List<CourseBean> findCourseByInfo(Map<String, Object> map) {
		return courseMapper.getCourseByInfo(map);
	}
	//修改课程信息
	@Override
	public int updateCourseInfo(Map<String, Object> map) {
		return courseMapper.updateCourseInfo(map);
	}
	
	/**
	 * 前台部分
	 */
	//通过课程名字查找课程信息
	@Override
	public List<CourseBean> findCourseByCname(Map<String, Object> map) {
		return courseMapper.getCourseByCname(map);
	}
	
	//根据课程编号查询课程具体信息
	@Override
	public List<CourseBean> showCoursesByCno(Map<String, Object> map) {
		return courseMapper.showCoursesByCno(map);
	}
	
	//根据课程方向查找课程信息
	@Override
	public List<CourseBean> findCourseByCdirname(Map<String, Object> map) {
		return courseMapper.getCourseByCdirname(map);
	}
	
	//根据课程类型名查找课程信息
	@Override
	public List<CourseBean> findCourseByCtname(Map<String, Object> map) {
		return courseMapper.getCourseByCtname(map);
	}
	
	//根据课程难易度查找课程信息
	@Override
	public List<CourseBean> findCourseByDname(Map<String, Object> map) {
		return courseMapper.getCourseByDname(map);
	}

	/**
	 * 根据cNo查找课程信息
	 * @param cNo
	 * @return
	 */
	@Override
	public List<CourseBean> findBycno(String cNo) {
		return courseMapper.findBycno(cNo);
	}
}
