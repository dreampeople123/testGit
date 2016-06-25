package com.dream.muke.entity;

/**
 * 评论
 * @author dream
 *
 */
public class Comments {
    private String coNo;
    private String uNo;
    private String chNo;
    private String coTime;
    private int coDianzannum;
    private String coPic;
    private int coStatus;
    private String coContent;
    
	public String getCoNo() {
		return coNo;
	}
	public void setCoNo(String coNo) {
		this.coNo = coNo;
	}
	public String getuNo() {
		return uNo;
	}
	public void setuNo(String uNo) {
		this.uNo = uNo;
	}
	public String getChNo() {
		return chNo;
	}
	public void setChNo(String chNo) {
		this.chNo = chNo;
	}
	public String getCoTime() {
		return coTime;
	}
	public void setCoTime(String coTime) {
		this.coTime = coTime;
	}
	public int getCoDianzannum() {
		return coDianzannum;
	}
	public void setCoDianzannum(int coDianzannum) {
		this.coDianzannum = coDianzannum;
	}
	public String getCoPic() {
		return coPic;
	}
	public void setCoPic(String coPic) {
		this.coPic = coPic;
	}
	public int getCoStatus() {
		return coStatus;
	}
	public void setCoStatus(int coStatus) {
		this.coStatus = coStatus;
	}
	public String getCoContent() {
		return coContent;
	}
	public void setCoContent(String coContent) {
		this.coContent = coContent;
	}
	
	public String toString() {
		return "Comments [coNo=" + coNo + ", uNo=" + uNo + ", chNo=" + chNo
				+ ", coTime=" + coTime + ", coDianzannum=" + coDianzannum
				+ ", coPic=" + coPic + ", coStatus=" + coStatus
				+ ", coContent=" + coContent + "]";
	}
}