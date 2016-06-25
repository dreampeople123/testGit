package com.dream.muke.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.CType;
import com.dream.muke.entity.UCourseBean;
import com.dream.muke.service.CTypeService;
import com.dream.muke.service.UcourseService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("ucourseAction")
@Scope("prototype")
public class UcourseAction implements ModelDriven<UCourseBean> {
	@Autowired
	private UcourseService ucourseService;
	@Autowired
	private CTypeService cTypeService;
	private Map<String,Object> ucourses;//查询所返回的结果
	@Autowired
	private UCourseBean uCourseBean;
	private int ucourse_result;//修改返回的结果
	private Map<String,Object> map;//查询时的参数
	private List<CType> cTypes;//根据用户是否关注，学习情况查找所学的课程的课程类型
	
	

	public List<CType> getcTypes() {
		return cTypes;
	}
	public int getUcourse_result() {
		return ucourse_result;
	}
	public Map<String, Object> getUcourses() {
		return ucourses;
	}
	/**
	 * 查询所有的用户课程信息
	 * @return
	 */
public String getUcourseInfo(){
	ucourses=new HashMap<String, Object>();
	ucourses.put("total", ucourseService.totalUcourse(uCourseBean));
	ucourses.put("rows", ucourseService.findUcourse(uCourseBean));
	return "ucourseInfo";
	
}
/**
 * 保存修改的信息
 * @return
 */
public String updateUcourseInfo(){
	ucourse_result=ucourseService.updateUcourseInfo(uCourseBean);
	return "ucourse_result";
	
}
/**
 * 模糊查询ucourse
 * @return
 */
public String findUcourseByInfo(){
	ucourses=new HashMap<String, Object>();
	uCourseBean.setPage("1");
	uCourseBean.setRows("10");
	ucourses.put("total", ucourseService.totalUcourse(uCourseBean));
	ucourses.put("rows", ucourseService.findUcourse(uCourseBean));
	return "ucourseInfo";
}
/**
 * 在我的课程界面获取用户的课程
 * @return
 */
public String getUserCourse(){
	ucourses=new HashMap<String, Object>();
	uCourseBean.setRows("5");
	System.out.println("yonghu课程"+uCourseBean);
	List<UCourseBean>  ucos= ucourseService.findUcourse(uCourseBean);
	int myal= ucourseService.totalUcourse(uCourseBean);
	ucourses.put("ucourss", ucos);
	ucourses.put("mytotal", myal);
	System.out.println("结果是的是"+ucos+"\n"+myal);
	return "ucourseInfo";

}
/**
 * 根据用户是否关注，学习情况查找所学的课程的课程类型
 * @return
 */
public String getUserCourseDir(){
	cTypes=new ArrayList<CType>();
	System.out.println("是否关注"+uCourseBean);
	map=new HashMap<String, Object>();
	map.put("uNo", uCourseBean.getuNo());
	map.put("ucAttention", 2);
	map.put("ucLearnstatus", -1);
	cTypes=cTypeService.findByMap(map);
	System.out.println("关注后"+cTypes);
	return "findAllCourseType";
	
}
	@Override
	public UCourseBean getModel() {
		return uCourseBean;
	}
}
