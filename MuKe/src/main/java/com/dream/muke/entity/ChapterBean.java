package com.dream.muke.entity;

/**
 * 章节
 * @author dream
 *
 */
public class ChapterBean {
    private String chNo;
    private String chName;
    private CourseBean course;
    private String chContent;
    private int chOrder;
    private int chStatus;
    
    private int cNo;
    
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public CourseBean getCourse() {
		return course;
	}
	public void setCourse(CourseBean course) {
		this.course = course;
	}
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
	
	public String getcName() {
		if(course!=null){
			return course.getcName();
		}
		
		return chName;
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
	
	public String getInfo(){ //课程名-章节名
		if(course!=null){
			return course.getcName()+"-"+chName;
		}
		
		return "hello";
	}
	@Override
	public String toString() {
		return "ChapterBean [chNo=" + chNo + ", chName=" + chName + ", course="
				+ course + ", chContent=" + chContent + ", chOrder=" + chOrder
				+ ", chStatus=" + chStatus + "]";
	}
	

}