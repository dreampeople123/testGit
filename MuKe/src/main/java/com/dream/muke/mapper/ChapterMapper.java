package com.dream.muke.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.Chapter;
import com.dream.muke.entity.ChapterBean;
import com.dream.muke.entity.UploadChapterBean;

/**
 * 章节表映射接口
 * @author dream
 *
 */
@Repository
public interface ChapterMapper {
	/**
	 * 获取所有的章节信息
	 * @return
	 */
	public List<ChapterBean> findAllChapters();

	/**
	 * 添加章节
	 * @param params
	 * @return
	 */
	public int addNewChapter(UploadChapterBean chapter);

	//查询所有的chapter内容
	List<ChapterBean> getAllChpater(Map<String, Integer> map);
	
	//根据章节编号,课程编号查找章节信息
	List<ChapterBean> getChapterByChnoOrCname(Map<String, Object> map);

	//根据章节编号查找章节信息
	List<ChapterBean> getChapterDetailByChno(Map<String, Object> map);

	//修改章节状态
	int updateChapterStatus(Map<String, Object> map);
	
	//删除章节信息
	int delChapterInfo(Map<String, Object> map);

	
	/**
	 * 前台内容
	 */
	//根据课程编号查询章节信息
	List<Chapter> getAllChpaterByCno(Map<String, Object> map);
	/**
	 * 查询章节信息（cno,ucNowChNo）
	 * @param map
	 * @return
	 */
	public ChapterBean findChapter(Map<String, Object> map);
}
