package com.dream.muke.entity;

/**
 * 难易度
 * @author dream
 *
 */
public class Deeply {
    private String dNo;
    private String dName;
    private int dStatus;
	public String getdNo() {
		return dNo;
	}
	public void setdNo(String dNo) {
		this.dNo = dNo;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public int getdStatus() {
		return dStatus;
	}
	public void setdStatus(int dStatus) {
		this.dStatus = dStatus;
	}
	@Override
	public String toString() {
		return "Deeply [dNo=" + dNo + ", dName=" + dName + ", dStatus="
				+ dStatus + "]";
	}
	public Deeply(String dNo, String dName, int dStatus) {
		super();
		this.dNo = dNo;
		this.dName = dName;
		this.dStatus = dStatus;
	}
	public Deeply() {
		super();
	}
    
    
}