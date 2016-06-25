package com.dream.muke.entity;

/**
 * 课程
 * @author dream
 *
 */
public class Course {
    private String cNo;
    private String cName;
    private String dNo;
    private String ctNo;
    private String cUpdatetime;
    private int cUpstatus;
    private String cPic;
    private int cStatus;
    private String cProfiles;
    
    
	public String getcProfiles() {
		return cProfiles;
	}
	public void setcProfiles(String cProfiles) {
		this.cProfiles = cProfiles;
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
	public String getdNo() {
		return dNo;
	}
	public void setdNo(String dNo) {
		this.dNo = dNo;
	}
	public String getCtNo() {
		return ctNo;
	}
	public void setCtNo(String ctNo) {
		this.ctNo = ctNo;
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
	public String getcPic() {
		return cPic;
	}
	public void setcPic(String cPic) {
		this.cPic = cPic;
	}
	public int getcStatus() {
		return cStatus;
	}
	public void setcStatus(int cStatus) {
		this.cStatus = cStatus;
	}
	
	public String toString() {
		return "Course [cNo=" + cNo + ", cName=" + cName + ", dNo=" + dNo
				+ ", ctNo=" + ctNo + ", cUpdatetime=" + cUpdatetime
				+ ", cUpstatus=" + cUpstatus + ", cPic=" + cPic + ", cStatus="
				+ cStatus + ", cProfiles=" + cProfiles + "]";
	}
}