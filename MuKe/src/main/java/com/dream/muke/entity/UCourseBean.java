package com.dream.muke.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 用户学习的课程
 * @author dream
 *
 */
@Component("uCourseBean")
@Scope("prototype")
public class UCourseBean {
    private String uNo;
    private String cNo;
    private int ucAttention;
    private int ucLearnstatus;
    private String ucNowChNo;
    private int ucStatus;
    //ucourse之外的属性 uname,cname,cpic,updatetime
    private String cName;//课程名字
    private String cUpdatetime;//跟新时间
    private String cPic;//课程图片
    private String uName;//用户名字
    private int maxChapter; //本门课的最大章节数
	private int page;//进行分页的page
	private int rows;//进行分页的rows

    private String ctNo;//课程类别信息


	public String getCtNo() {
		return ctNo;
	}
	public void setCtNo(String ctNo) {
		this.ctNo = ctNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcUpdatetime() {
		return cUpdatetime;
	}
	public void setcUpdatetime(String cUpdatetime) {
		this.cUpdatetime = cUpdatetime;
	}
	public String getcPic() {
		return cPic;
	}
	public void setcPic(String cPic) {
		this.cPic = cPic;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getMaxChapter() {
		return maxChapter;
	}
	public void setMaxChapter(int maxChapter) {
		this.maxChapter = maxChapter;
	}
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
	
	public int getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = Integer.parseInt(page);
	}

	public int getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows =  Integer.parseInt(rows);
	}
	@Override
	public String toString() {
		return "UCourseBean [uNo=" + uNo + ", cNo=" + cNo + ", ucAttention="
				+ ucAttention + ", ucLearnstatus=" + ucLearnstatus
				+ ", ucNowChNo=" + ucNowChNo + ", ucStatus=" + ucStatus
				+ ", cName=" + cName + ", cUpdatetime=" + cUpdatetime
				+ ", cPic=" + cPic + ", uName=" + uName + ", maxChapter="
				+ maxChapter + ", page=" + page + ", rows=" + rows + ", ctNo="
				+ ctNo + "]";
	}
	



	

}