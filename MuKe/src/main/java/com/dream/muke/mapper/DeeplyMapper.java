package com.dream.muke.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import java.util.Map;
import com.dream.muke.entity.Deeply;

/**
 * 课程难易度表映射接口
 * @author dream
 *
 */
@Repository("deeplyMapper")
public interface DeeplyMapper {
	/**
	 * 获取所有的难易度信息
	 * @return
	 */
	public List<Deeply> getDeeply();

	//获取课程难易度信息
	List<Deeply> getAllDeeplyInfo(Map<String, Object> map);

	//增加课程难易度信息
	int addDeeplyInfo(Map<String, Object> map);

	//修改课程难易程度信息
	int updateDeeplyInfo(Map<String, Object> map);

	//删除课程难易程度信息
	int delDeeplyInfo(Map<String, Object> map);

	//查找所有课程难易度信息
	List<Deeply> findAllDeeply();
}
