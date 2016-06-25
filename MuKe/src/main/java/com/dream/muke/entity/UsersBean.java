package com.dream.muke.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 用户
 * @author dream
 *
 */
@Component("usersBean")
@Scope("prototype")
public class UsersBean  implements Serializable{
    /**
	 * 序列化操作方便传输
	 */
	private static final long serialVersionUID = 7135992730109075559L;
	private String uNo; //用户编号
    private String uName; //用户名
    private String uPwd; //用户密码
    private String uAddress_prov; //省
    private String uAddress_city; //市
    private String uAddress_county; //县
    private String uSex; //性别
    private String uUsign; //个性签名
    private String uPic; //头像
    private String uTel; //手机
    private int uIsTeacher=-1; //0表示不是教师 1表示为是教师 -1表示所有
    private int uStudytime; //学习时间
    private int ustatus;//删除标记  0已被删除 1为存在
	private int page;//进行分页的page
	private int rows;//进行分页的rows
    private String uSummary;//应聘时用的简介字段
    private String uTry;//试讲视频
    private String uRealname;//真实姓名
    
	public String getuSummary() {
		return uSummary;
	}
	public void setuSummary(String uSummary) {
		this.uSummary = uSummary;
	}
	public String getuTry() {
		return uTry;
	}
	public void setuTry(String uTry) {
		this.uTry = uTry;
	}
	public String getuRealname() {
		return uRealname;
	}
	public void setuRealname(String uRealname) {
		this.uRealname = uRealname;
	}
	public String getuAddress_prov() {
		return uAddress_prov;
	}
	public void setuAddress_prov(String uAddress_prov) {
		this.uAddress_prov = uAddress_prov;
	}
	public String getuAddress_city() {
		return uAddress_city;
	}
	public void setuAddress_city(String uAddress_city) {
		this.uAddress_city = uAddress_city;
	}
	public String getuAddress_county() {
		return uAddress_county;
	}
	public void setuAddress_county(String uAddress_county) {
		this.uAddress_county = uAddress_county;
	}
	/**
	 * 转为Integer类型方便操作
	 * @return
	 */
	public int getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = Integer.parseInt(page);
	}



	public int getRows() {
		return  rows;
	}
	public void setRows(String rows) {
		this.rows = Integer.parseInt(rows);
	}
	public String getuNo() {
		return uNo;
	}
	public String getuNos() {
		return uNo;
	}
	public void setuNo(String uNo) {
		this.uNo = uNo;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public String getuSex() {
		return uSex;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public String getuUsign() {
		return uUsign;
	}
	public void setuUsign(String uUsign) {
		this.uUsign = uUsign;
	}
	public String getuPic() {
		return uPic;
	}
	public void setuPic(String uPic) {
		this.uPic = uPic;
	}
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}
	public int getuIsTeacher() {
		return uIsTeacher;
	}
	public void setuIsTeacher(int uIsTeacher) {
		this.uIsTeacher = uIsTeacher;
	}
	public int getuStudytime() {
		return uStudytime;
	}
	public void setuStudytime(int uStudytime) {
		this.uStudytime = uStudytime;
	}
	public int getUstatus() {
		return ustatus;
	}
	public void setUstatus(int ustatus) {
		this.ustatus = ustatus;
	}
	@Override
	public String toString() {
		return "UsersBean [uNo=" + uNo + ", uName=" + uName + ", uPwd=" + uPwd
				+ ", uAddress_prov=" + uAddress_prov + ", uAddress_city="
				+ uAddress_city + ", uAddress_county=" + uAddress_county
				+ ", uSex=" + uSex + ", uUsign=" + uUsign + ", uPic=" + uPic
				+ ", uTel=" + uTel + ", uIsTeacher=" + uIsTeacher
				+ ", uStudytime=" + uStudytime + ", ustatus=" + ustatus
				+ ", page=" + page + ", rows=" + rows + ", uSummary="
				+ uSummary + ", uTry=" + uTry + ", uRealname=" + uRealname
				+ "]";
	}
	




	

}