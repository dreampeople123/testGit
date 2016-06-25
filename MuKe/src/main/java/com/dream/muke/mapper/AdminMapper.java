package com.dream.muke.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.Admin;

/**
 * 管理员映射接口
 * @author Administrator
 *
 */
@Repository("adminMapper")
public interface AdminMapper {
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
	public List<Admin> findAllAdmin(Map<String,Integer> map);
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
