package com.dream.muke.entity;

/**
 * 评论bean，将外键写为类
 * @author dream
 *
 */
public class CommentBean {
    private String coNo;
    private Users user;
    private ChapterBean chapter;
    private String coTime;
    private int coDianzannum;
    private String coPic;
    private int coStatus;
    private String coContent;
    
    private String chNo;
    
    private int page;
    private int rows;
    
    
    public int getPagea(){
    	return page*rows;
    }
    public int getPageb(){
    	return (page-1)*rows;
    }
    
	public String getChNo() {
		return chNo;
	}
	public void setChNo(String chNo) {
		this.chNo = chNo;
	}
	public String getCoNo() {
		return coNo;
	}
	public void setCoNo(String coNo) {
		this.coNo = coNo;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}

	public ChapterBean getChapter() {
		return chapter;
	}
	public void setChapter(ChapterBean chapter) {
		this.chapter = chapter;
	}
	public String getCoTime() {
		return coTime;
	}
	public void setCoTime(String coTime) {
		this.coTime = coTime;
	}
	public int getCoDianzannum() {
		return coDianzannum;
	}
	public void setCoDianzannum(int coDianzannum) {
		this.coDianzannum = coDianzannum;
	}
	public String getCoPic() {
		return coPic;
	}
	public void setCoPic(String coPic) {
		this.coPic = coPic;
	}
	public int getCoStatus() {
		return coStatus;
	}
	public void setCoStatus(int coStatus) {
		this.coStatus = coStatus;
	}
	public String getCoContent() {
		return coContent;
	}
	public void setCoContent(String coContent) {
		this.coContent = coContent;
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
	
	public String toString() {
		return "CommentBean [coNo=" + coNo + ", user=" + user + ", chapter="
				+ chapter + ", coTime=" + coTime + ", coDianzannum="
				+ coDianzannum + ", coPic=" + coPic + ", coStatus=" + coStatus
				+ ", coContent=" + coContent + ", chNo=" + chNo + "]";
	}
}