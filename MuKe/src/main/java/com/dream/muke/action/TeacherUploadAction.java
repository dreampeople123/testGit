package com.dream.muke.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.NewCourseUploadBean;
import com.dream.muke.entity.UploadChapterBean;
import com.dream.muke.service.CourseService;
import com.dream.muke.utils.DateUtil;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 教师上传课程，视频
 * @author Administrator
 *
 */
@Controller("teacherUploadAction")
public class TeacherUploadAction implements ModelDriven<NewCourseUploadBean>{
	private NewCourseUploadBean course;
	@Autowired
	private CourseService courseService;
	
	private int result=0; //json数据传递结果
	
	private File video; //上传的视频
	private File cPic; //上传的课程图片
	private String videoFileName; //视频名字
	private String cPicFileName; //图片名字
	private String chName; //章节名
	private String uno; //用户编号
	
	public void setVideo(File video) {
		this.video = video;
	}
	public void setcPic(File cPic) {
		this.cPic = cPic;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	public void setVideoFileName(String videoFileName) {
		this.videoFileName = videoFileName;
	}
	public void setcPicFileName(String cPicFileName) {
		this.cPicFileName = cPicFileName;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	
	public int getResult() {
		return result;
	}
	
	public NewCourseUploadBean getModel() {
		course=new NewCourseUploadBean();
		return course;
	}	

	/**
	 * 上传新的课程
	 * @return
	 */
	public String uploadCourse(){
		//String path=ServletActionContext.getServletContext().getRealPath("upload/");
		String path="F:/安装软件/tomcat/apache-tomcat-7.0.47/webapps/upload";
		
		String videoName = new DateUtil().getFileName()+videoFileName;
		String cPicName = new DateUtil().getFileName()+cPicFileName;
		
		try {
			FileUtils.copyFile( video,new File(path+"/"+videoName)); //上传video
			LogManager.getLogger().error("文件上传成功"+path);
			
			FileUtils.copyFile( cPic,new File(path+"/"+cPicName)); //上传cPic
			LogManager.getLogger().error("文件上传成功"+path);
			
			course.setPicPath(cPicName);
			result=courseService.uploadCourse(course,videoName,chName,uno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "uploadCourse";
	}
	
	/**
	 * 上传新的章节
	 * @return
	 */
	public String uploadChapter(){
		//String path=ServletActionContext.getServletContext().getRealPath("upload/");
		String path="F:/安装软件/tomcat/apache-tomcat-7.0.47/webapps/upload";
		String fileName=new DateUtil().getFileName()+videoFileName;
		UploadChapterBean chapter=new UploadChapterBean(chName,course.getCno(),fileName,0,uno);
		try {
			FileUtils.copyFile(video, new File(path+"/"+fileName));  //上传video
			LogManager.getLogger().debug("上传成功:"+path);
			result=courseService.uploadChapter(chapter);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "uploadChapter";
	}
}
