package com.dream.muke.service;

import java.util.List;

import com.dream.muke.entity.Answer;

public interface AnswerService {
	/**
	 * 获取问题下的回答
	 * @param getaNo
	 * @return
	 */
	public List<Answer> getAskAnswerByNo(String aNo);

	/**
	 * 添加回答信息
	 * @param getaNo
	 * @param uNo
	 * @param anContent
	 * @param fileName
	 */
	public int addAnswer(String aNo, String uNo, String anContent,String fileName);
}
