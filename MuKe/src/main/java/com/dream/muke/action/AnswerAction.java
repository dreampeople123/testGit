package com.dream.muke.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.Answer;
import com.dream.muke.service.AnswerService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("answerAction")
public class AnswerAction implements ModelDriven<Answer>{
	private Answer answer;
	private List<Answer> answers; //传到后台的json数据
	
	@Autowired
	private AnswerService answerService;

	public Answer getModel() {
		answer=new Answer();
		return answer;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * 获取这个问答的回答信息
	 * @return
	 */
	public String getAskAnswer(){
		answers=new ArrayList<Answer>();
		answers=answerService.getAskAnswerByNo(answer.getaNo());
		return "getAskAnswer";
	}
}
