package com.dream.muke.entity;

import java.io.Serializable;

/**
 * 社区的热门课程
 * @author Administrator
 *
 */
public class CommunityHotCourseBean implements Serializable {
	private static final long serialVersionUID = 9081874931673433384L;
	
	private Course course; //课程信息
	private int attNum; //关注人数
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getAttNum() {
		return attNum;
	}
	public void setAttNum(int attNum) {
		this.attNum = attNum;
	}
	
	public String toString() {
		return "\nCommunityHotCourse [course=" + course + ", attNum=" + attNum
				+ "]";
	}
}
