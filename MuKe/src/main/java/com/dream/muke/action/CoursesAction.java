package com.dream.muke.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.CType;
import com.dream.muke.entity.Chapter;
import com.dream.muke.entity.ChapterBean;
import com.dream.muke.entity.CommentBean;
import com.dream.muke.entity.CourseBean;
import com.dream.muke.entity.Deeply;
import com.dream.muke.service.CTypeService;
import com.dream.muke.service.ChapterService;
import com.dream.muke.entity.UCourseBean;
import com.dream.muke.entity.UsersBean;
import com.dream.muke.entity.frontAsk;
import com.dream.muke.service.AskService;
import com.dream.muke.service.CommentService;
import com.dream.muke.service.CourseService;
import com.dream.muke.service.DeeplyService;
import com.dream.muke.service.UcourseService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("coursesAction")
@Scope("prototype")
public class CoursesAction implements ModelDriven<CourseBean>,SessionAware{
	private CourseBean courseBean;
	private List<CourseBean> coursesInfo;
	@Autowired
	private CourseService courseService;
	@Autowired
	private CTypeService cTypeService;
	@Autowired
	private DeeplyService deeplyService;
	@Autowired
	private ChapterService chapterService;
	private int page;//进行分页的page
	private int rows;//进行分页的rows
	@Autowired
	private UcourseService ucourseService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private AskService askService;
	private Map<String,Object> map;

	private List<CourseBean> courses;

	//增修返回值
	private int status;
	private Map<String, Object> session;
	
	public List<CourseBean> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseBean> courses) {
		this.courses = courses;
	}


	//在点击查看视频界面中穿过来的值
	private String uno;//用户编号
	private String chapterno;//章节编号
	private String cno;//课程编号
	private String ucnowChNo;//现在学习到的章节数
	
	public void setUcnowChNo(String ucnowChNo) {
		this.ucnowChNo = ucnowChNo;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public void setChapterno(String chapterno) {
		this.chapterno = chapterno;
	}
	public void setSession(Map<String, Object> session) {//获得session
		this.session=session;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public List<CourseBean> getCoursesInfo() {
		return coursesInfo;
	}
	public void setCoursesInfo(List<CourseBean> coursesInfo) {
		this.coursesInfo = coursesInfo;
	}
	/**
	 * 后台部分
	 * @return
	 */

	//查找所有课程信息
	public String findCourseInfo(){
		map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("rows", rows);
		coursesInfo = courseService.findCourseInfo(map);
		return "findCourseInfo";
	}

	//按照课程名或课程类别编号查找课程信息
	public String findCourseByInfo(){
		map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("rows", rows);
		map.put("cName", courseBean.getcName());
		map.put("ctNo", Integer.parseInt(courseBean.getCtNo()));

		System.out.println(courseBean.getcName()+"传过来的类别名");
		System.out.println(Integer.parseInt(courseBean.getCtNo())+"闯过来的类别id");
		coursesInfo = courseService.findCourseByInfo(map);
		return "findCourseByInfo";
	}

	//修改课程信息
	public String updateCourseInfo(){
		map = new HashMap<String, Object>();
		map.put("cNo", courseBean.getcNo());
		map.put("cName", courseBean.getcName());
		map.put("cUpstatus", courseBean.getcUpstatus());
		map.put("cStatus", courseBean.getcStatus());

		status = courseService.updateCourseInfo(map);
		return "updateCourseInfo";
	}

	/**
	 * 前台部分
	 */
	//根据课程名查找课程信息
	public String findCourseByCname(){
		map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("rows", rows);
		map.put("cName", courseBean.getcName());

		System.out.println(courseBean.getcName()+"传过来的课程名");
		coursesInfo = courseService.findCourseByCname(map);
		session.put("courseBean", coursesInfo);
		if(coursesInfo!=null){
			status=1;
		}else{
			status=0;
		}
		return "findCourseByCname";
	}

	//点击课程的时候,链接到course.jsp,显示所有的课程方向,类别,难易,和课程显示
	public String findAllTypes(){
		List<CType> cTypes = cTypeService.findAllCourseType();
		
		
		session.put("cTypeInfo", cTypes);
		
		session.put("allDir", cTypeService.findAllDir());
		
		List<Deeply> deeply = deeplyService.findAllDeeply();
		session.put("deeplyInfo", deeply);
		Map<String,Object> map1 = new HashMap<String, Object>();
		map1.put("page", page);
		map1.put("rows", rows);
		courses = courseService.findCourseInfo(map1);
		session.put("courseInfo", courses);
		System.out.println(courses+"课程信息");
		System.out.println("课程类别"+cTypes+"课程难易"+deeply);
		return "findAllTypes";
	}


	public String showCoursesByCno(){
		map = new HashMap<String, Object>();
		map.put("cNo", courseBean.getcNo());
		List<CourseBean> coursesInfo = courseService.showCoursesByCno(map);
		session.put("courseInfo", coursesInfo);
		List<Chapter> chapters = chapterService.findAllChapterByCno(map);
		session.put("chapterInfo", chapters);
		return "showCoursesByCno";
	}

	/**
	 * 获得视频界面的所有信息
	 * @return
	 */
	public String getshipinDataInfo(){
		System.out.println("课程编号安抚"+cno+"章节编号"+chapterno+"用户编号"+uno);
		session.put("riuno", uno);
		session.put("richapterno", chapterno);
		session.put("ricno", cno);

		//调用函数查找章节信息，同学信息有关课程
		getChapterTong( cno, uno, chapterno);
		//调用函数查找评论信息
		getCommentBean(chapterno);
		//问答信息
		getaskin(cno);
		status = 1;//表示信息查到成功
		return "shipinInfo";//借用上面参数返回1
	}
	/**
	 * 获取查看视频时的评论信息
	 * @param chapterno
	 */
	public void getCommentBean(String chapterno){
		CommentBean com=new CommentBean();//临时的来查询的CommentBean
		com.setChNo(chapterno);
		com.setPage(1);
		com.setRows(10);
		List<CommentBean> comments=commentService.findCommentsByInfo(com); //获得评论信息
		session.put("comments", comments);
	}
	/**
	 * 获得查看视频界面的章节同学信息
	 */
	public void getChapterTong(String cno,String uno,String chapterno){
		System.out.println("进入方法.....");
		System.out.println("课程编号"+cno+"章节编号"+chapterno+"用户编号"+uno);
		UCourseBean ucur=new UCourseBean();
		ucur.setcNo(cno);
		ucur.setuNo(uno);
		ucur.setPage("1");
		ucur.setRows("10");
		System.out.println("阿三"+ucur);
		System.out.println("阿是的三"+ucourseService.findUcourse(ucur));
		UCourseBean daucourse=ucourseService.findUcourse(ucur).get(0);
		//	System.out.println("用户课程"+daucourse+"用户课程水电费水电费");
		session.put("daucourse", daucourse);//uno 和cno对应的用户课程
		ChapterBean danchapter=new ChapterBean();
		map = new HashMap<String, Object>();
		//数据放入map中方便mapper
		map.put("cNo",cno);
		map.put("uNo",uno);
		map.put("chNo",chapterno);
		List<ChapterBean> chapters=chapterService.findChapterBycNoOrchName(map);//获得章节信息
		System.out.println(chapters+"当前章节信息");
		session.put("chapters", chapters);
		CourseBean dancourse= (CourseBean) courseService.findBycno(cno).get(0);//获得课程名称
		System.out.println(dancourse+"当前课程名称");
		session.put("dancourse", dancourse);
		for(int i=0;i<chapters.size();i++){
			if(Integer.parseInt(chapters.get(i).getChNo())==Integer.parseInt(chapterno)){
				danchapter=chapters.get(i);
			}
		}
		session.put("danchapter", danchapter);//当前的章节
		List<UsersBean> tongxue=ucourseService.findUsBychano(map);//查询这门课程有什么人在学 
		int counu=ucourseService.totalChapterno(map);//查询这门课程有多少人在学 
		List<CourseBean> sameUcourse=ucourseService.sameByCno(cno);//查询学习这门课程的同学学习的其他课程
		session.put("counu",counu);
		session.put("tongxue",tongxue);
		session.put("sameUcourse", sameUcourse);
	}
	/**
	 * 获得问答的信息
	 * @param cno
	 */
	public void getaskin(String cno){
		CourseBean coure=(CourseBean) courseService.findBycno(cno).get(0);
		Map<String, Object>  maps=new HashMap<String, Object>();
		maps.put("cNo", cno);
		maps.put("ctNo", coure.getCtNo());
		//根据cno查询问题
		List<frontAsk> asks=askService.findForntAsk(maps);
		session.put("asks", asks);
		System.out.println("查到的asks"+asks);
	}
	/**
	 * 获得视频界面所有的问答信息
	 */
	public String getAllAskInfo(){
		String cno=(String) session.get("ricno");
		System.out.println("quanbu"+cno);
		//查询问答信息
		getaskin( cno);
		status = 1;
		return "shipinInfo";//借用上面参数返回1
	}
	/**
	 * 点击某一章节后
	 */
	public String getshipinBychapter() {
		String uno=(String) session.get("riuno");
		String cno=(String) session.get("ricno");
		session.put("richapterno", chapterno);
		session.put("ricno", cno);
		session.put("riuno", uno);
		//调用函数查找章节信息，同学信息有关课程
		getChapterTong( cno, uno, chapterno);
		//调用函数查找评论信息
		getCommentBean(chapterno);
		//问答信息
		getaskin(cno);
		status = 1;//表示信息查到成功
		return "shipinInfo";//借用上面参数返回1
	}
	/**
	 * 点击精华问答信息
	 * @return
	 */
	public String getJinhuaAskInfo(){
		String cno=(String) session.get("ricno");
		System.out.println("jingha"+cno);
		CourseBean coure=(CourseBean) courseService.findBycno(cno).get(0);
		Map<String, Object>  maps=new HashMap<String, Object>();
		maps.put("cNo", cno);
		maps.put("ctNo", coure.getCtNo());
		//根据cno查询问题
		List<frontAsk> asks=askService.findJinAskByCtype(maps);
		session.put("asks", asks);
		System.out.println("查到的asks"+asks);
		status = 1;//表示信息查到成功
		return "shipinInfo";//借用上面参数返回1
	}
	/**
	 * 视频界面点击最新的评论
	 * @return
	 */
	public String getLastComInfo(){
		String chapterno=(String) session.get("richapterno");
		System.out.println("zuixin"+chapterno);
		getCommentBean(chapterno);
		status = 1;//表示信息查到成功
		return "shipinInfo";//借用上面参数返回1
	}
	/**
	 * 视频界面点击点赞查询评论
	 * @return
	 */
	public String getComInfoBydian(){
		String chapterno=(String) session.get("richapterno");
		System.out.println("点赞"+chapterno);
		CommentBean com=new CommentBean();//临时的来查询的CommentBean
		com.setChNo(chapterno);
		com.setPage(1);
		com.setRows(10);
		List<CommentBean> comments=commentService.findCommentByDian(com); //获得评论信息
		session.put("comments", comments);
		return chapterno;
	}
	/**
	 * 在我的界面点击跳到视频查看界面
	 * @return
	 */
	public String gotoChapter(){
		System.out.println("ke跳视频"+uno+cno+ucnowChNo);
		map=new HashMap<String, Object>();
		map.put("cNo", cno);
		map.put("chOrder", ucnowChNo);
		ChapterBean techapter=chapterService.findChapter(map);//根据（cNo，ucNowChNo）查出相应信息
		String temchapterno=techapter.getChNo();
		session.put("riuno", uno);
		session.put("richapterno", temchapterno);
		session.put("ricno", cno);
		//调用函数查找章节信息，同学信息有关课程
		getChapterTong( cno, uno, temchapterno);
		//调用函数查找评论信息
		getCommentBean(temchapterno);
		//问答信息
		getaskin(cno);
		status = 1;//表示信息查到成功
		return "shipinInfo";//借用上面参数返回1
		
	}
	/**
	 * 在我的评论点击跳到视频查看界面
	 * @return
	 */
	public String gotoCha(){
		System.out.println("ke跳视频"+uno+cno+chapterno);
		session.put("riuno", uno);
		session.put("richapterno", chapterno);
		session.put("ricno", cno);
		//调用函数查找章节信息，同学信息有关课程
		getChapterTong( cno, uno, chapterno);
		//调用函数查找评论信息
		getCommentBean(chapterno);
		//问答信息
		getaskin(cno);
		status = 1;//表示信息查到成功
		
		return "shipinInfo";//借用上面参数返回1
		
	}
	@Override
	public CourseBean getModel() {
		courseBean = new CourseBean();
		return courseBean;
	}
}
