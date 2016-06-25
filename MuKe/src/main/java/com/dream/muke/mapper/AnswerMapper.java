package com.dream.muke.mapper;

import java.util.List;
import java.util.Map;

import com.dream.muke.entity.Answer;

/**
 * 问题表映射接口
 * @author dream
 *
 */
public interface AnswerMapper {
	/**
	 * 获取问题下的回答
	 * @param getaNo
	 * @return
	 */
	public List<Answer> getAskAnswerByNo(String aNo);

	/**
	 * 根据问题编号删除问题下的回答信息
	 * @param aNo
	 */
	public void delAskAnswerByANo(String aNo);

	/**
	 * 根据问题编号找到最新回答
	 * @param getaNo
	 * @return
	 */
	public Answer findNewAnswerByAno(String aNo);

	/**
	 * 添加回答信息
	 * @param params
	 * @return
	 */
	public int addAnswer(Map<String, Object> params);
}