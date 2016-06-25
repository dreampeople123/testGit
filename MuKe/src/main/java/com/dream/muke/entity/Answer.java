package com.dream.muke.entity;

/**
 * 回答
 * @author dream
 *
 */
public class Answer {
    private String anNo;
    private String aNo;
    private String uNo;
    private String anTime;
    private int anStatus;
    private String anContent;
    
    private String anPic;
    
	public String getAnNo() {
		return anNo;
	}
	public void setAnNo(String anNo) {
		this.anNo = anNo;
	}
	public String getaNo() {
		return aNo;
	}
	public void setaNo(String aNo) {
		this.aNo = aNo;
	}
	public String getuNo() {
		return uNo;
	}
	public void setuNo(String uNo) {
		this.uNo = uNo;
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
	public String getAnPic() {
		return anPic;
	}
	public void setAnPic(String anPic) {
		this.anPic = anPic;
	}
	
	public String toString() {
		return "Answer [anNo=" + anNo + ", aNo=" + aNo + ", uNo=" + uNo
				+ ", anTime=" + anTime + ", anStatus=" + anStatus
				+ ", anContent=" + anContent + ", anPic=" + anPic + "]";
	}
}