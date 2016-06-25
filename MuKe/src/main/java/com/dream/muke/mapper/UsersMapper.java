package com.dream.muke.mapper;

import java.util.List;

import com.dream.muke.entity.Course;
import com.dream.muke.entity.UploadChapterBean;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.UsersBean;

/**
 * 用户映射接口
 * @author dream
 *
 */
@Repository("usersMapper")
public interface UsersMapper {
	/**
	 * 获取该教师维护的所有的课程
	 * @param uNo
	 * @return
	 */
	public List<Course> getTeacherCourse(String uNo);

	/**
	 * 添加教师维护课程信息
	 * @param chapter
	 * @return
	 */
	public int addTeacherCourse(UploadChapterBean chapter);

	/** 查询users的信息到usersBean
	 * @param usersBean
	 * @return
	 */
	public List<UsersBean> findUsers(UsersBean usersBean);
	/**
	 * 总记录数
	 * @return
	 */
	public int total(Map<String,Object> map);
	/**
	 * 批量删除用户数据
	 * @param uNos
	 * @return
	 */
	public int delUsers(String[] uNos);
	/**
	 * 更新用户数据
	 * @param usersBean
	 * @return
	 */
	public int updateUsers(UsersBean usersBean);
	/**
	 * 用户注册
	 * @return
	 */
	public int addUsreInfo(UsersBean usersBean);
}
