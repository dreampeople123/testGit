package com.dream.muke.entity;

/**
 * 提问
 * @author dream
 *
 */
public class Ask {
    private String aNo;
    private String ctNo;
    private String uNo;
    private String aTitle;
    private String aTime;
    private int aStatus;
    private String aContent;
    private String aPic;

	public String getaPic() {
		return aPic;
	}
	public void setaPic(String aPic) {
		this.aPic = aPic;
	}
	public String getaNo() {
		return aNo;
	}
	public void setaNo(String aNo) {
		this.aNo = aNo;
	}
	public String getCtNo() {
		return ctNo;
	}
	public void setCtNo(String ctNo) {
		this.ctNo = ctNo;
	}
	public String getuNo() {
		return uNo;
	}
	public void setuNo(String uNo) {
		this.uNo = uNo;
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
		return "Ask [aNo=" + aNo + ", ctNo=" + ctNo + ", uNo=" + uNo
				+ ", aTitle=" + aTitle + ", aTime=" + aTime + ", aStatus="
				+ aStatus + ", aContent=" + aContent + ", aPic=" + aPic + "]";
	}
}