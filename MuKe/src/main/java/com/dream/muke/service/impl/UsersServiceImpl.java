package com.dream.muke.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.Course;
import com.dream.muke.entity.Users;
import com.dream.muke.entity.UsersBean;
import com.dream.muke.mapper.UsersMapper;
import com.dream.muke.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usersMapper;

	public List<Course> getTeacherCourse(String uNo) {
		return usersMapper.getTeacherCourse(uNo);
	}

	/**
	 * 查询users的信息到usersBean
	 * @param usersBean
	 * @return
	 */
	public List<UsersBean> findUsers(UsersBean usersBean) {
		return usersMapper.findUsers(usersBean);
	}
	
	public List<Users> findUsers(Users user, int page, int rows) {
		return null;
	}
	
	/**
	 * 总记录数
	 * @return
	 */
	public int total(Map<String,Object> map) {
		return usersMapper.total(map);
	}
 	/**
	 * 批量删除用户数据
	 * @param uNos
	 * @return
	 */
	public int delUsers(String[] uNos) {
		return usersMapper.delUsers(uNos);
	}
	/**
	 * 更新用户数据
	 * @param usersBean
	 * @return
	 */
	public int updateUsers(UsersBean usersBean) {
		return usersMapper.updateUsers(usersBean);
	}
	/**
	 * 用户注册
	 * @return
	 */
	public UsersBean addUsreInfo(UsersBean usersBean) {
		int res=usersMapper.addUsreInfo(usersBean);
		if(res>0){
			return usersBean;
		}
		return null;
	}
}
