package com.dream.muke.entity;

/**
 * 章节
 * @author dream
 *
 */
public class Chapter {
    private String chNo;
    private String chName;
    private String cNo;
    private String chContent;
    private int chOrder;
    private int chStatus;
    
	public String getChNo() {
		return chNo;
	}
	public void setChNo(String chNo) {
		this.chNo = chNo;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	public String getcNo() {
		return cNo;
	}
	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	public String getChContent() {
		return chContent;
	}
	public void setChContent(String chContent) {
		this.chContent = chContent;
	}
	public int getChOrder() {
		return chOrder;
	}
	public void setChOrder(int chOrder) {
		this.chOrder = chOrder;
	}
	public int getChStatus() {
		return chStatus;
	}
	public void setChStatus(int chStatus) {
		this.chStatus = chStatus;
	}

	public String toString() {
		return "Chapter [chNo=" + chNo + ", chName=" + chName + ", cNo=" + cNo
				+ ", chContent=" + chContent + ", chOrder=" + chOrder
				+ ", chStatus=" + chStatus + "]";
	}
}