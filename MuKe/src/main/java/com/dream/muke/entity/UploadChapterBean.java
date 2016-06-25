package com.dream.muke.entity;

/**
 * 上传章节时候的bean
 * @author Administrator
 *
 */
public class UploadChapterBean {
	private String chName;
	private String cNo;
	private String chContent;
	private String uno;
	private int chOrder=0;
	
	public UploadChapterBean() {
	}
	public UploadChapterBean(String chName, String cNo, String chContent,int chOrder) {
		super();
		this.chName = chName;
		this.cNo = cNo;
		this.chContent = chContent;
		this.chOrder = chOrder;
	}
	public UploadChapterBean(String chName, String cNo, String chContent,int chOrder,String uno) {
		super();
		this.chName = chName;
		this.cNo = cNo;
		this.chContent = chContent;
		this.chOrder = chOrder;
		this.uno=uno;
	}
	
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	public String getcNo() {
		return cNo;
	}
	public void setcNo(String cNo) {
		this.cNo = cNo;
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
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	
	public String toString() {
		return "UploadChapterBean [chName=" + chName + ", cNo=" + cNo
				+ ", chContent=" + chContent + ", uno=" + uno + ", chOrder="
				+ chOrder + "]";
	}
}
