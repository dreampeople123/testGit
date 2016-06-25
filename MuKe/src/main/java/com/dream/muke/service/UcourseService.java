package com.dream.muke.service;

import java.util.List;
import java.util.Map;

import com.dream.muke.entity.CourseBean;
import com.dream.muke.entity.UCourseBean;
import com.dream.muke.entity.UsersBean;

public interface UcourseService {
	/**
	 * 查询UCourse信息返回到UCourseBean
	 * @param uCourseBean
	 * @return
	 */
	public List<UCourseBean> findUcourse(UCourseBean uCourseBean);
	/**
	 * 总记录数
	 * @param uCourseBean
	 * @return
	 */
	public int totalUcourse(UCourseBean uCourseBean);
	/**
	 * 保存修改的信息
	 * @return
	 */
	public int updateUcourseInfo(UCourseBean uCourseBean);
	/**
	 *查找学习同一课程的同学
	 * @param map
	 * @return
	 */
	public List<UsersBean> findUsBychano(Map<String,Object>  map);
	/**
	 * 查找学习同一课程的同学的数量
	 * @param map
	 * @return
	 */
	public int totalChapterno(Map<String,Object>  map);
	/**
	 * 查找同学学习的其他课程
	 * @param cno
	 * @return
	 */
	public List<CourseBean> sameByCno(String cNo);
}
