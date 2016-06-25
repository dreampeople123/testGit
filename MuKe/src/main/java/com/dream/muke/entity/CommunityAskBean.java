package com.dream.muke.entity;

import java.io.Serializable;

/**
 * 社区的问答信息
 * @author Administrator
 *
 */
public class CommunityAskBean implements Serializable {
	private static final long serialVersionUID = -74649328116638665L;
	
	private int answerNum; //回答人数
	private Users user; //提问者信息
	private Ask ask; //问题信息
	private Answer answer; //最新的回答
	private String cTname; //类型
	
	public int getAnswerNum() {
		return answerNum;
	}
	public void setAnswerNum(int answerNum) {
		this.answerNum = answerNum;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Ask getAsk() {
		return ask;
	}
	public void setAsk(Ask ask) {
		this.ask = ask;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public String getcTname() {
		return cTname;
	}
	public void setcTname(String cTname) {
		this.cTname = cTname;
	}
	
	public String toString() {
		return "\nCommunityAskBean [answerNum=" + answerNum + ", user=" + user
				+ ", ask=" + ask + ", answer=" + answer + ", cTname=" + cTname
				+ "]";
	}
}
