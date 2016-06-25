package com.dream.muke.entity;

/**
 * ask的bean,将外键写成类
 * @author Administrator
 *
 */
public class BackAskBean {
    private String aNo;
    private CType cType;
    private Users user;
    private String aTitle;
    private String aTime;
    private int aStatus;
    private String aContent;
    
    private String typeNo;
    
    private int page;
    private int rows;
    
    public int getPagea(){
    	return page*rows;
    }
    public int getPageb(){
    	return (page-1)*rows;
    }
    
	public String getTypeNo() {
		return typeNo;
	}
	public void setTypeNo(String typeNo) {
		this.typeNo = typeNo;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getaNo() {
		return aNo;
	}
	public void setaNo(String aNo) {
		this.aNo = aNo;
	}
	public CType getcType() {
		return cType;
	}
	public void setcType(CType cType) {
		this.cType = cType;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getaTitle() {
		return aTitle;
	}
	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}
	public String getaTime() {
		return aTime;
	}
	public void setaTime(String aTime) {
		this.aTime = aTime;
	}
	public int getaStatus() {
		return aStatus;
	}
	public void setaStatus(int aStatus) {
		this.aStatus = aStatus;
	}
	public String getaContent() {
		return aContent;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	
	public String toString() {
		return "\nBackAskBean [aNo=" + aNo + ", cType=" + cType + ", user="
				+ user + ", aTitle=" + aTitle + ", aTime=" + aTime
				+ ", aStatus=" + aStatus + ", aContent=" + aContent + "]";
	}
}
