package com.dream.muke.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.CType;
import com.dream.muke.mapper.CTypeMapper;
import com.dream.muke.service.CTypeService;

@Service("cTypeService")
public class CTypeServiceImpl implements CTypeService {
	@Autowired
	private CTypeMapper cTypeMapper;

	public List<CType> findAllCourseType() {
		return cTypeMapper.findAllCourseType();
	}

	public List<CType> findAllDir() {
		return cTypeMapper.findAllDir();
	}

	public List<CType> findTypeByDir(String key) {
		return cTypeMapper.findTypeByDir(key);
	}
	
	//删除课程类别信息
	@Override
	public int delCourseTypeInfo(Map<String, Object> map) {
		return cTypeMapper.delCourseTypeInfo(map);
	}

	//更改课程类别信息
	@Override
	public int updateCourseTypeInfo(Map<String, Object> map) {
		return cTypeMapper.updateCourseTypeInfo(map);
	}

	//添加课程类别信息
	@Override
	public int addCourseTypeInfo(Map<String, Object> map) {
		return cTypeMapper.addCourseTypeInfo(map);
	}

	/*
		前台部分
	 */
	/**
	 * 根据用户是否关注，学习情况查找所学的课程的课程类型
	 * @param map
	 * @return
	 */
	@Override
	public List<CType> findByMap(Map<String, Object> map) {
		return cTypeMapper.findByMap(map);
	}
}
