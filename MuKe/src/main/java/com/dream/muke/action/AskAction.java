package com.dream.muke.action;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.Ask;
import com.dream.muke.entity.BackAskBean;
import com.dream.muke.entity.UsersBean;
import com.dream.muke.service.AnswerService;
import com.dream.muke.entity.CourseBean;
import com.dream.muke.service.AskService;
import com.dream.muke.service.CourseService;
import com.dream.muke.utils.DateUtil;
import com.dream.muke.utils.SessionKey;
import com.opensymphony.xwork2.ModelDriven;

@Controller("askAction")
public class AskAction implements ModelDriven<BackAskBean>,SessionAware{
	private BackAskBean backAskBean;
	private Map<String, Object> session;
	@Autowired
	private AskService askService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private AnswerService answerService;
	private Map<String,Object> map;
	private Map<String,Object> asks=new HashMap<String, Object>(); //传到后台的json信息
	private int result; //传到后台的数据更新结果
	private String askNos; //问题编号
	private String anContent; //回答内容
	private File answerImg;
	private String answerImgFileName;
	private String uNo;

	private File askImg;
	private String askImgFileName;
	
	public void setAskImg(File askImg) {
		this.askImg = askImg;
	}
	public void setAskImgFileName(String askImgFileName) {
		this.askImgFileName = askImgFileName;
	}
	public void setuNo(String uNo) {
		this.uNo = uNo;
	}
	public void setAnswerImgFileName(String answerImgFileName) {
		this.answerImgFileName = answerImgFileName;
	}
	public void setAnswerImg(File answerImg) {
		this.answerImg = answerImg;
	}
	public void setAnContent(String anContent) {
		this.anContent = anContent;
	}
	public void setAskNos(String askNos) {
		this.askNos = askNos;
	}
	
	public Map<String,Object> getAsks() {
		return asks;
	}
	public int getResult() {
		return result;
	}

	public BackAskBean getModel() {
		backAskBean=new BackAskBean();
		return backAskBean;
	}
	

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	/**
	 * 添加问题信息
	 * @return
	 */
	public String addAsk(){
		String path="F:/安装软件/tomcat/apache-tomcat-7.0.47/webapps/upload";
		String fileName=new DateUtil().getFileName()+askImgFileName;
		
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("ctNo", backAskBean.getTypeNo());
		params.put("uNo", uNo);
		params.put("aTitle", backAskBean.getaTitle());
		params.put("aContent", backAskBean.getaContent());
		params.put("aTime", new DateUtil().getDate());
		
		if(askImg!=null){
			try {
				params.put("aPic",fileName);
				FileUtils.copyFile(askImg, new File(path+"/"+fileName));
				LogManager.getLogger().debug("文件上传成功"+path);
			} catch (IOException e) {
				LogManager.getLogger().debug("文件上传失败");
				e.printStackTrace();
			}
		} else{
			params.put("aPic","");
		}
		askService.addAsk(params);
		
		return findCommunityInfo();
	}
	
	/**
	 * 获取社区的信息
	 * @return
	 */
	public String findCommunityInfo(){
		backAskBean.setRows(10); //一个页面显示10条数据
		
		session.put(SessionKey.COMMUNITY_ASKS, askService.findCommunityAsks(backAskBean));
		session.put(SessionKey.COMMUNITY_HOTCOURSE, courseService.findCommunityHotCourse());
		session.put(SessionKey.COMMUNITY_HOTASK, askService.findCommunityHotAsk());
		session.put(SessionKey.COMMUNITY_HOTUSER, askService.findCommunityHotUser());

		System.out.println(session.get(SessionKey.COMMUNITY_HOTUSER));
		
		return "findCommunityInfo";
	}

	/**
	 * 获取全部的问答信息
	 * @return
	 */
	public String getAskInfo(){
		asks.put("rows",askService.getAskInfo(backAskBean));
		asks.put("total", askService.getAskTotal(backAskBean));
		return "getAskInfo";
	}
	
	/**
	 * 根据类型找到问题信息
	 */
	public String findAskByType(){
		if("0".equals(backAskBean.getTypeNo())){
			backAskBean.setTypeNo(null);
			asks.put("rows",askService.getAskInfo(backAskBean));
			asks.put("total", askService.getAskTotal(backAskBean));
		} else{
			asks.put("rows",askService.findAskByType(backAskBean));
			asks.put("total", askService.getAskTotal(backAskBean));
		}
		return "getAskInfo";
	}
	
	/**
	 * 删除ask信息
	 * @return
	 */
	public String delAskInfo(){
		try {
			askService.delAskInfo(askNos);
			result=1;
		} catch (Exception e) {
			result=0;
			LogManager.getLogger().debug("删除问题信息失败",e);
		}
		return "delAskInfo";
	}
	
	/**
	 * 跳转到问题详情界面
	 * @return
	 */
	public String gotoQuestion(){
		session.put(SessionKey.QUESTION_INFO, askService.findAskBeanByNo(askNos)); //引用社区askbean
		session.put(SessionKey.QUESTION_ANSWERS, answerService.getAskAnswerByNo(askNos));
		return "gotoQuestion";
	}
	
	/**
	 * 添加回答
	 * @return
	 */
	public String addAnswer(){
		String path="F:/安装软件/tomcat/apache-tomcat-7.0.47/webapps/upload";
		String fileName=new DateUtil().getFileName()+answerImgFileName;
		
		if(answerImg!=null){
			try {
				FileUtils.copyFile(answerImg, new File(path+"/"+fileName));
				LogManager.getLogger().debug("上传成功:"+path);
				answerService.addAnswer(backAskBean.getaNo(),uNo,anContent,fileName);
			} catch (IOException e) {
				LogManager.getLogger().debug("上传图片失败");
				e.printStackTrace();
			}
		} else{
			answerService.addAnswer(backAskBean.getaNo(),uNo,anContent,"");
		}
		System.out.println(anContent);
		return gotoQuestion();
	}

	/**
	 * 视频界面添加问答信息
	 * @return
	 */
	public String addAsks(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String askTime=sdf.format(new Date());
		Ask ask=new Ask();
		ask.setaTime(askTime);
		ask.setaContent(backAskBean.getaContent());
		ask.setaTitle(backAskBean.getaTitle());
		ask.setuNo((String) session.get("riuno"));
		CourseBean couu=(CourseBean) session.get("dancourse");
		ask.setCtNo(couu.getCtNo());
		System.out.println("添加的"+ask);
		 result=askService.addAsk(ask);
		 System.out.println("结果是"+result);
		return "shipin";
	}
	/**
	 * 在我的课程界面点击我的问答
	 * @return
	 */
	public String getMyAsk(){
		map=new HashMap<String, Object>();
		UsersBean use=(UsersBean) session.get("loginUser");
		backAskBean.setRows(5);
		System.out.println("点击我的问答"+backAskBean);
		map.put("uNo", use.getuNo());
		session.put("asks", askService.findForntAsk(map));
		result=1;
		return "delAskInfo";//使用之前标识传递json
		
		}

}
