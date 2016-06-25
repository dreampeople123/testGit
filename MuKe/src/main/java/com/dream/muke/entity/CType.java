package com.dream.muke.entity;

/**
 * 课程类别
 * @author dream
 *
 */
public class CType {
    private String ctNo;
    private String ctName;
    private String ctDirname;
    private int ctStatus;
    
	public String getCtNo() {
		return ctNo;
	}
	public void setCtNo(String ctNo) {
		this.ctNo = ctNo;
	}
	public String getCtName() {
		return ctName;
	}
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}
	public String getCtDirname() {
		return ctDirname;
	}
	public void setCtDirname(String ctDirname) {
		this.ctDirname = ctDirname;
	}
	public int getCtStatus() {
		return ctStatus;
	}
	public void setCtStatus(int ctStatus) {
		this.ctStatus = ctStatus;
	}
	
	public String toString() {
		return "Ctype [ctNo=" + ctNo + ", ctName=" + ctName + ", ctDirname="
				+ ctDirname + ", ctStatus=" + ctStatus + "]";
	}
}