package com.dream.muke.service;

import java.util.List;

import com.dream.muke.entity.Admin;

public interface AdminService {
	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	public Admin adminLogin(Admin admin);
	/**
	 * 查询所有的管理员信息
	 * @return
	 */

	public List<Admin> findAllAdmin(int page,int rows);
	/**
	 * 添加管理员信息
	 * @return
	 */
	public int addAdmin(Admin admin);
	/**
	 * 修改管理员信息
	 * @param admin
	 * @return
	 */
	
	public int updateAdmin(Admin admin);
	/**
	 * 删除管理员信息
	 * @param aId
	 * @return
	 */
	public int delAdmin(String aId);
	
}
