package com.dream.muke.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.Deeply;
import com.dream.muke.mapper.DeeplyMapper;
import com.dream.muke.service.DeeplyService;
import java.util.HashMap;
import java.util.Map;

@Service("deeplyService")
public class DeeplyServiceImpl implements DeeplyService {
	@Autowired
	private DeeplyMapper deeplyMapper;

	public List<Deeply> getDeeply() {
		return deeplyMapper.getDeeply();
	}
	
	//获得课程难易度信息
	@Override
	public List<Deeply> findAllDeeplyInfo(int page, int rows) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		map.put("rows", rows);
		return deeplyMapper.getAllDeeplyInfo(map);
	}
	
	//添加课程难易度
	@Override
	public int addDeeplyInfo(Map<String, Object> map) {
		return deeplyMapper.addDeeplyInfo(map);
	}

	@Override
	public int updateDeeplyInfo(Map<String, Object> map) {
		return deeplyMapper.updateDeeplyInfo(map);
	}

	//删除课程难易程度信息
	@Override
	public int delDeeplyInfo(Map<String, Object> map) {
		return deeplyMapper.delDeeplyInfo(map);
	}

	//查找所有难易度信息
	@Override
	public List<Deeply> findAllDeeply() {
		return deeplyMapper.findAllDeeply();
	}

}
