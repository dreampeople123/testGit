package com.dream.muke.entity;

/**
 * 提问
 * @author dream
 *
 */
public class frontAsk {
    private String aNo;//问答编号
    private String ctNo;//问题的种类（课程的种类）
    private String uNo;//用户编号
    private String aTitle;//问题标题
    private String aTime;//提问时间
    private int aStatus;//问题状态
    private String aContent;//问题内容
    //表之外的属性
    private String uPic;//用户头像
    private String uName;//用户名
    private String ctDirname; //方向名
    private String ctName;//类型名
    /*private int total =0;//总记录数
*/    private AnswerBean lastAnswer;//第一个回答
    private int answernum=0; //回答人数
    
	public String getuPic() {
		return uPic;
	}
	public void setuPic(String uPic) {
		this.uPic = uPic;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
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

	public int getAnswernum() {
		return answernum;
	}
	public void setAnswernum(int answernum) {
		this.answernum = answernum;
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
	public AnswerBean getLastAnswer() {
		return lastAnswer;
	}
	public void setLastAnswer(AnswerBean lastAnswer) {
		this.lastAnswer = lastAnswer;
	}
	@Override
	public String toString() {
		return "frontAsk [aNo=" + aNo + ", ctNo=" + ctNo + ", uNo=" + uNo
				+ ", aTitle=" + aTitle + ", aTime=" + aTime + ", aStatus="
				+ aStatus + ", aContent=" + aContent + ", uPic=" + uPic
				+ ", uName=" + uName + ", ctDirname=" + ctDirname + ", ctName="
				+ ctName + ", lastAnswer=" + lastAnswer + ", answernum="
				+ answernum + "]";
	}


}