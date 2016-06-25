package com.dream.muke.entity;

import com.dream.muke.utils.DateUtil;

/**
 * 新课程上传的bean
 * @author Administrator
 *
 */
public class NewCourseUploadBean {
	private String ctNo;
	private String dNo;
	private String cUpdatetime;
	private int cUpstatus;
	private String picPath;
	private int cStatus;
	private String cName;
	private String cno;
	private String cProfiles;
	
	public NewCourseUploadBean(){
		this.cUpdatetime=new DateUtil().getDate();
		this.cUpstatus=1;
		this.cStatus=2;
	}
	
	public String getCtNo() {
		return ctNo;
	}
	public void setCtNo(String ctNo) {
		this.ctNo = ctNo;
	}
	public String getdNo() {
		return dNo;
	}
	public void setdNo(String dNo) {
		this.dNo = dNo;
	}
	public String getcUpdatetime() {
		return cUpdatetime;
	}
	public void setcUpdatetime(String cUpdatetime) {
		this.cUpdatetime = cUpdatetime;
	}
	public int getcUpstatus() {
		return cUpstatus;
	}
	public void setcUpstatus(int cUpstatus) {
		this.cUpstatus = cUpstatus;
	}
	public int getcStatus() {
		return cStatus;
	}
	public void setcStatus(int cStatus) {
		this.cStatus = cStatus;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getcProfiles() {
		return cProfiles;
	}
	public void setcProfiles(String cProfiles) {
		this.cProfiles = cProfiles;
	}

	public String toString() {
		return "NewCourseUploadBean [ctNo=" + ctNo + ", dNo=" + dNo
				+ ", cUpdatetime=" + cUpdatetime + ", cUpstatus=" + cUpstatus
				+ ", picPath=" + picPath + ", cStatus=" + cStatus + ", cName="
				+ cName + ", cno=" + cno + ", cProfiles=" + cProfiles + "]";
	}
}
