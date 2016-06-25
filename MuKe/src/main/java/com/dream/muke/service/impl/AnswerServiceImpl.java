package com.dream.muke.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.Answer;
import com.dream.muke.mapper.AnswerMapper;
import com.dream.muke.service.AnswerService;
import com.dream.muke.utils.DateUtil;

@Service("answerService")
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private AnswerMapper answerMapper;

	public List<Answer> getAskAnswerByNo(String aNo) {
		return answerMapper.getAskAnswerByNo(aNo);
	}

	/**
	 * 添加回答信息
	 */
	public int addAnswer(String aNo, String uNo, String anContent,String fileName) {
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("aNo", aNo);
		params.put("anContent", anContent);
		params.put("uNo", uNo);
		params.put("anTime", new DateUtil().getDate());
		params.put("anPic", fileName);
		return answerMapper.addAnswer(params);
	}
}
