package com.dream.muke.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.CourseBean;
import com.dream.muke.entity.UCourseBean;
import com.dream.muke.entity.UsersBean;
import com.dream.muke.mapper.UCourseMapper;
import com.dream.muke.service.UcourseService;
@Service("ucourseService")
public class UcourseServiceImpl implements UcourseService {
	@Autowired
	private UCourseMapper uCourseMapper;
	/**
	 * 查询UCourse信息返回到UCourseBean
	 * @param uCourseBean
	 * @return
	 */
	@Override
	public List<UCourseBean> findUcourse(UCourseBean uCourseBean) {
		return uCourseMapper.findUcourse(uCourseBean);
	}
	/**
	 * 总记录数
	 * @param uCourseBean
	 * @return
	 */
	@Override
	public int totalUcourse(UCourseBean uCourseBean) {
		return uCourseMapper.totalUcourse(uCourseBean);
	}
	/**
	 * 保存修改的信息
	 * @return
	 */
	@Override
	public int updateUcourseInfo(UCourseBean uCourseBean) {
		return uCourseMapper.updateUcourseInfo(uCourseBean);
	}
	/**
	 *查找学习同一课程的同学
	 * @param uno
	 * @param cno
	 * @return
	 */
	@Override
	public List<UsersBean> findUsBychano(Map<String,Object>  map) {
		return uCourseMapper.findUsBychano( map);
	}
	/**
	 * 查找学习同一课程的同学的数量
	 * @param map
	 * @return
	 */
	@Override
	public int totalChapterno(Map<String, Object> map) {
		return uCourseMapper.totalChapterno(map);
	}
	/**
	 * 查找同学学习的其他课程
	 * @param cno
	 * @return
	 */
	@Override
	public List<CourseBean> sameByCno(String cNo){
		return uCourseMapper.sameByCno(cNo);
		
	}
}
