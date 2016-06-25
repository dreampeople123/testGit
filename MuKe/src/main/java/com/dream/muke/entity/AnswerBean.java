package com.dream.muke.entity;

/**
 * 回答的bean，将外键写成类
 * @author Administrator
 *
 */
public class AnswerBean {
    private String anNo;
    private Ask ask;
    private Users user;
    private String anTime;
    private int anStatus;
    private String anContent;
    private String anPic;
    
    
    
	public String getAnPic() {
		return anPic;
	}
	public void setAnPic(String anPic) {
		this.anPic = anPic;
	}
	public String getAnNo() {
		return anNo;
	}
	public void setAnNo(String anNo) {
		this.anNo = anNo;
	}
	public Ask getAsk() {
		return ask;
	}
	public void setAsk(Ask ask) {
		this.ask = ask;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getAnTime() {
		return anTime;
	}
	public void setAnTime(String anTime) {
		this.anTime = anTime;
	}
	public int getAnStatus() {
		return anStatus;
	}
	public void setAnStatus(int anStatus) {
		this.anStatus = anStatus;
	}
	public String getAnContent() {
		return anContent;
	}
	public void setAnContent(String anContent) {
		this.anContent = anContent;
	}

	public String toString() {
		return "AnswerBean [anNo=" + anNo + ", ask=" + ask + ", user=" + user
				+ ", anTime=" + anTime + ", anStatus=" + anStatus
				+ ", anContent=" + anContent + ", anPic=" + anPic + "]";
	}
}
