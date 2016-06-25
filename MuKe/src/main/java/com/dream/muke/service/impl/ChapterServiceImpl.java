package com.dream.muke.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.Chapter;
import com.dream.muke.entity.ChapterBean;
import com.dream.muke.mapper.ChapterMapper;
import com.dream.muke.service.ChapterService;

@Service("chapterService")
public class ChapterServiceImpl implements ChapterService {
	@Autowired
	private ChapterMapper chapterMapper;
	
	@Override
	public List<ChapterBean> findAllChapters() {
		return chapterMapper.findAllChapters();
	}
	
	@Override
	public List<ChapterBean> findAllChapter(int page,int rows) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("page", page);
		map.put("rows", rows);
		return chapterMapper.getAllChpater(map);
	}
	@Override
	public List<ChapterBean> findChapterBycNoOrchName(Map<String, Object> map) {
		return chapterMapper.getChapterByChnoOrCname(map);
	}
	@Override
	public List<ChapterBean> showChapterDetail(Map<String, Object> map) {
		return chapterMapper.getChapterDetailByChno(map);
	}
	//修改章节的状态
	@Override
	public int updateChapterStatus(Map<String, Object> map) {
		return chapterMapper.updateChapterStatus(map);
	}
	
	//删除章节
	@Override
	public int delChapterInfo(Map<String, Object> map) {
		return chapterMapper.delChapterInfo(map);
	}
	
	/**
	 * 前台内容
	 */
	//根据课程编号查询章节信息
	@Override
	public List<Chapter> findAllChapterByCno(Map<String, Object> map) {
		return chapterMapper.getAllChpaterByCno(map);
	}
	/**
	 * 查询章节信息（cno,ucNowChNo）
	 * @param map
	 * @return
	 */
	@Override
	public ChapterBean findChapter(Map<String, Object> map) {
		return chapterMapper.findChapter(map);
	}
}
