package com.dream.muke.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.Admin;
import com.dream.muke.mapper.AdminMapper;
import com.dream.muke.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;

	public Admin adminLogin(Admin admin) {
		return adminMapper.adminLogin(admin);
	}
	/**
	 * 查询所有的管理员信息
	 * @return
	 */
	@Override
	public List<Admin> findAllAdmin(int page,int rows) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("page", page);
		map.put("rows", rows);
		List<Admin> ads=adminMapper.findAllAdmin(map);
		return ads;
	}
	/**
	 * 添加管理员信息
	 * @return
	 */
	@Override
	public int  addAdmin(Admin admin) {
		return adminMapper.addAdmin(admin);
	}
	/**
	 * 修改管理员信息
	 * @param admin
	 * @return
	 */
	@Override
	public int updateAdmin(Admin admin) {
		 return adminMapper.updateAdmin( admin);
	}
	/**
	 * 删除管理员信息
	 * @param aId
	 * @return
	 */
	@Override
	public int delAdmin(String aId) {
		return adminMapper.delAdmin( aId);
	}

}
