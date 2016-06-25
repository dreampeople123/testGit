package com.dream.muke.entity;

/**
 * 用户学习的课程
 * @author dream
 *
 */
public class UCourse {
    private String uNo;
    private String cNo;
    private int ucAttention;
    private int ucLearnstatus;
    private String ucNowChNo;
    private int ucStatus;
    
	public String getuNo() {
		return uNo;
	}
	public void setuNo(String uNo) {
		this.uNo = uNo;
	}
	public String getcNo() {
		return cNo;
	}
	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	public int getUcAttention() {
		return ucAttention;
	}
	public void setUcAttention(int ucAttention) {
		this.ucAttention = ucAttention;
	}
	public int getUcLearnstatus() {
		return ucLearnstatus;
	}
	public void setUcLearnstatus(int ucLearnstatus) {
		this.ucLearnstatus = ucLearnstatus;
	}
	public String getUcNowChNo() {
		return ucNowChNo;
	}
	public void setUcNowChNo(String ucNowChNo) {
		this.ucNowChNo = ucNowChNo;
	}
	public int getUcStatus() {
		return ucStatus;
	}
	public void setUcStatus(int ucStatus) {
		this.ucStatus = ucStatus;
	}
	
	public String toString() {
		return "UCourse [uNo=" + uNo + ", cNo=" + cNo + ", ucAttention="
				+ ucAttention + ", ucLearnstatus=" + ucLearnstatus
				+ ", ucNowChNo=" + ucNowChNo + ", ucStatus=" + ucStatus + "]";
	}
}