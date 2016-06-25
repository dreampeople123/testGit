package com.dream.muke.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.UsersBean;
import com.dream.muke.service.UsersService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
public class UserAction implements SessionAware, ModelDriven<UsersBean> {
	@Autowired
	private UsersService usersService;
	private Map<String, Object > users;
	@Autowired
	private UsersBean usersBean;//增删改查临时接收的usersBean	
	private int users_result;//进行删改的的结果int类型
	private Map<String,Object> session;
	
	private Map<String,Object> couerses=new HashMap<String, Object>();
	


	public int getUsers_result() {
		return users_result;
	}

	public Map<String, Object> getUsers() {
		return users;
	}
	
	public Map<String, Object> getCouerses() {
		return couerses;
	}
	
	/**
	 * 审核教师
	 * @return
	 */
	public String sehen(){
		users_result=usersService.updateUsers(usersBean);
		return "users_result";
	}
	/**
	 * 后台查询用户信息
	 * @return
	 */
	public String getPageUserInfo(){
		usersBean.setuIsTeacher(-1);//查询所有给-1
		Map<String,Object> totals=new HashMap<String,Object>();
		totals.put("uName", usersBean.getuName());
		totals.put("uIsTeacher", usersBean.getuIsTeacher());
		users = new HashMap<String, Object >();
		users.put("total", usersService.total(totals));
		users.put("rows", usersService.findUsers(usersBean));
		return "usersInfo";
	}
	
	/**
	 * 获取该教师维护的所有的课程
	 * @return
	 */
	public String getTeacherCourse(){
		couerses.put("infos", usersService.getTeacherCourse(usersBean.getuNo()));
		return "getTeacherCourse";
	}
	
	/**
	 * 查看详细的用户信息
	 * @return
	 */
	public String findNewsByUno(){
		usersBean.setuIsTeacher(-1);
		usersBean.setPage("1");
		usersBean.setRows("10");
		users = new HashMap<String, Object >();
		List<UsersBean> ress= usersService.findUsers(usersBean);
		users.put("rows", usersService.findUsers(usersBean));
		return "usersInfo";
	}
	/**
	 * 删除用户信息
	 * @return
	 */
	public String delUserInfo(){
		String unos=usersBean.getuNo();
		String[] uNos=unos.split(",");
		users_result=usersService.delUsers(uNos);
		return "users_result";
	}
	/**
	 * 模糊查询用户信息
	 * @return
	 */
	public String findUsersInfoByInfo(){
		usersBean.setPage("1");
		usersBean.setRows("10");
		Map<String,Object> totals=new HashMap<String,Object>();
		totals.put("uName", usersBean.getuName());
		totals.put("uIsTeacher", usersBean.getuIsTeacher());
		users = new HashMap<String, Object >();
		users.put("total", usersService.total(totals));
		users.put("rows", usersService.findUsers(usersBean));
		return "usersInfo";
	}
	/**
	 * 用户登录
	 * @return
	 */
	public String loginUser(){
		usersBean.setPage("1");
		usersBean.setRows("10");
		UsersBean use=usersService.findUsers(usersBean).get(0);
		if(use!=null){
			session.put("loginUser", use);
			users_result=1;
			return "users_result";
		}else {
			users_result=0;
			return "users_result";
		}
	}
	/**
	 * 用户退出
	 * @return
	 */
	public String loginOut(){
		session.put("loginUser", null);
		users_result=1;
		return "users_result";
	}
	/**
	 * 用户注册
	 * @return
	 */
	public String addUsreInfo(){
		usersBean.setuSex("男");
		usersBean.setuIsTeacher(0);
		usersBean.setUstatus(2);
		usersBean.setuUsign("这个人很懒没有签名");//设置默认签名
		usersBean.setuPic("upload/moren.jpg");//设置默认头像
		UsersBean use=usersService.addUsreInfo(usersBean);
		if(use!=null){
			session.put("loginUser", use);
			users_result=1;
			return "users_result";
		}else{
			users_result=0;
			return "users_result";
		}
	}
	/**
	 * 检查电话号码是否存在
	 * @return
	 */
	public String chTel(){
		usersBean.setPage("1");
		usersBean.setRows("10");
		int use=usersService.findUsers(usersBean).size();
		if(use!=0){
			users_result=0;
			return "users_result";
		}else{
			users_result=1;
			return "users_result";
		}
	}
	/**
	 * 检查名字是否存在
	 * @return
	 */
	public String chName(){
		usersBean.setPage("1");
		usersBean.setRows("10");
		int use=usersService.findUsers(usersBean).size();
		if(use!=0){
			users_result=0;
			return "users_result";
		}else{
			users_result=1;
			return "users_result";
		}
	}
	/**
	 * 我的课程界面更新用户信息
	 * @return
	 */
	public String updateUser(){
		System.out.println("wod更新用"+usersBean);
		users_result=usersService.updateUsers(usersBean);
		return "users_result";
		
	} 
	@Override
	public UsersBean getModel() {
		usersBean=new UsersBean();
		return usersBean;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
}
