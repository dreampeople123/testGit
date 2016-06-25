package com.dream.muke.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.Chapter;
import com.dream.muke.entity.ChapterBean;
@Repository
public interface ChapterService {
	
	/**
	 * 获取所有的章节信息
	 */
	public List<ChapterBean> findAllChapters();
	
	public List<ChapterBean> findAllChapter(int page,int rows);

	public List<ChapterBean> findChapterBycNoOrchName(Map<String, Object> map);

	public List<ChapterBean> showChapterDetail(Map<String, Object> map);

	//修改章节的状态
	public int updateChapterStatus(Map<String, Object> map);

	//删除章节
	public int delChapterInfo(Map<String, Object> map);

	/**
	 * 前台内容
	 */
	//根据课程编号查找章节信息
	public List<Chapter> findAllChapterByCno(Map<String, Object> map);
	/**
	 * 查询章节信息（cno,ucNowChNo）
	 * @param map
	 * @return
	 */
	public ChapterBean findChapter(Map<String, Object> map);
}
