package com.dream.muke.entity;

public class CourseBean {
	private String cNo;      //课程编号
	private String cName;    //课程名
	private String dName;    //难易程度
	private String ctDirname;//方向
	private String ctName;   //类型
	private String cUpdatetime;    //课程更新时间
    private int cUpstatus;      //是否跟新
    private int cStatus;   		//是否可用
    private String ctNo;   		//课程类别名
    private String cPic;    	//课程图片
    private String cProfiles;   //课程简介
    
	public String getcProfiles() {
		return cProfiles;
	}
	public void setcProfiles(String cProfiles) {
		this.cProfiles = cProfiles;
	}
	public String getcPic() {
		return cPic;
	}
	public void setcPic(String cPic) {
		this.cPic = cPic;
	}
    
    
	public String getcNo() {
		return cNo;
	}
	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getCtDirname() {
		return ctDirname;
	}
	public void setCtDirname(String ctDirname) {
		this.ctDirname = ctDirname;
	}
	public String getCtName() {
		return ctName;
	}
	public void setCtName(String ctName) {
		this.ctName = ctName;
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
	public String getCtNo() {
		return ctNo;
	}
	public void setCtNo(String ctNo) {
		this.ctNo = ctNo;
	}

	@Override
	public String toString() {
		return "CourseBean [cNo=" + cNo + ", cName=" + cName + ", dName="
				+ dName + ", ctDirname=" + ctDirname + ", ctName=" + ctName
				+ ", cUpdatetime=" + cUpdatetime + ", cUpstatus=" + cUpstatus
				+ ", cStatus=" + cStatus + ", ctNo=" + ctNo + ", cPic=" + cPic
				+ ", cProfiles=" + cProfiles + "]";
	}
	
	public CourseBean(String cNo, String cName, String dName, String ctDirname,
			String ctName, String cUpdatetime, int cUpstatus, int cStatus,
			String ctNo, String cPic, String cProfiles) {
		super();
		this.cNo = cNo;
		this.cName = cName;
		this.dName = dName;
		this.ctDirname = ctDirname;
		this.ctName = ctName;
		this.cUpdatetime = cUpdatetime;
		this.cUpstatus = cUpstatus;
		this.cStatus = cStatus;
		this.ctNo = ctNo;
		this.cPic = cPic;
		this.cProfiles = cProfiles;
	}
	public CourseBean() {
		super();
	}
	
	
	
}
