package com.dream.muke.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.CourseBean;
import com.dream.muke.entity.Deeply;
import com.dream.muke.service.CourseService;
import com.dream.muke.service.DeeplyService;
import java.util.List;

import com.dream.muke.entity.Deeply;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 难易度
 * 
 * @author Administrator
 *
 */
@Controller("deeplyAction")
public class DeeplyAction implements ModelDriven<Deeply>{
	@Autowired
	private DeeplyService deeplyService;

	private Map<String, Object> uoloadDeeplys = new HashMap<String, Object>(); // json数据
	private Deeply deeply;
	private List<Deeply> deeplys;
	private Map<String, Object> map;
	private String page;// 进行分页的page
	private String rows;// 进行分页的rows
	private int status;
	@Autowired
	private CourseService courseService;
	List<CourseBean> courses;

	public List<CourseBean> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseBean> courses) {
		this.courses = courses;
	}

	public Map<String, Object> getUoloadDeeplys() {
		return uoloadDeeplys;
	}

	/**
	 * 获取所有的难易度
	 * 
	 * @return
	 */
	public String getDeeply() {
		uoloadDeeplys.put("deeply", deeplyService.getDeeply());
		return "getDeeply";
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Deeply> getDeeplys() {
		return deeplys;
	}

	public void setDeeplys(List<Deeply> deeplys) {
		this.deeplys = deeplys;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	// 查询课程难易度的所有信息
	public String findAllDeeplyInfo() {
		deeplys = deeplyService.findAllDeeplyInfo(Integer.parseInt(page),
				Integer.parseInt(rows));
		return "findAllDeeplyInfo";
	}

	// 增加课程难易度信息
	public String addDeeplyInfo() {
		map = new HashMap<String, Object>();
		String dName = deeply.getdName();
		int dStatas = deeply.getdStatus();
		System.out.println("进来了...");
		System.out.println(dName + "   " + dStatas);
		map.put("dName", dName);
		map.put("dStatus", dStatas);

		status = deeplyService.addDeeplyInfo(map);
		System.out.println(status + "添加是否成功");
		return "addDeeplyInfo";
	}

	// 修改课程难易程度信息
	public String updateDeeplyInfo() {
		map = new HashMap<String, Object>();
		map.put("dNo", deeply.getdNo());
		map.put("dName", deeply.getdName());
		map.put("dStatus", deeply.getdStatus());
		status = deeplyService.updateDeeplyInfo(map);
		System.out.println(status + "修改是否成功");

		return "updateDeeplyInfo";
	}

	// 删除课程难易程度信息
	public String delDeeplyInfo() {
		map = new HashMap<String, Object>();
		String dNo = deeply.getdNo();
		int dStatus = deeply.getdStatus();
		map.put("dNo", dNo);
		// map.put("dStatus", dStatus);
		status = deeplyService.delDeeplyInfo(map);
		System.out.println(status + "结果........");
		return "delDeeplyInfo";
	}

	// 根据课程难易度查找课程信息
	public String showCourseByDname() {
		map = new HashMap<String, Object>();
		System.out.println(deeply.getdName()+"课程难易度");
		map.put("dName", deeply.getdName());
		courses = courseService.findCourseByDname(map);
		System.out.println(courses);
		return "showCourseByDname";
	}

	public Deeply getModel() {
		deeply = new Deeply();
		return deeply;
	}
}
