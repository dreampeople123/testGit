package com.dream.muke.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sun.misc.BASE64Decoder;

import com.dream.muke.entity.CommentBean;
import com.dream.muke.entity.Comments;
import com.dream.muke.entity.Users;
import com.dream.muke.entity.UsersBean;
import com.dream.muke.service.CommentService;
import com.opensymphony.xwork2.ModelDriven;
@Controller("commentAction")
public class CommentAction implements ModelDriven<CommentBean>,SessionAware{
	private CommentBean commentBean;
	@Autowired
	private CommentService commentService;
	
	private Map<String,Object> comments=new HashMap<String, Object>(); //往后台传的json数据
	private String coNos; //接收评论编号，用逗号分割
	private int result; //返回操作结果
	private Map<String, Object> session;//获得session对象
	
	public CommentBean getModel() {
		commentBean=new CommentBean();
		return commentBean;
	}
	
	public Map<String, Object> getComments() {
		return comments;
	}
	public int getResult() {
		return result;
	}

	public void setCoNos(String coNos) {
		this.coNos = coNos;
	}

	/**
	 * 获取所有的评论信息
	 * @return
	 */
	public String getAllComment(){
		comments.put("rows", commentService.getAllComment(commentBean));
		comments.put("total", commentService.getCommentTotal(commentBean));
		
		System.out.println(comments.get("rows"));
		return "getAllComment";
	}
	
	/**
	 * 根据章节找到评论信息
	 * @return
	 */
	public String findCommentsByInfo(){
		System.out.println(commentBean.getChNo());
		if("0".equals( commentBean.getChNo() )){
			commentBean.setChNo(null);
			comments.put("rows", commentService.getAllComment(commentBean));
		}else{
			comments.put("rows", commentService.findCommentsByInfo(commentBean));
		}
		comments.put("total", commentService.getCommentTotal(commentBean));
		return "getAllComment";
	}
	
	/**
	 * 删除评论信息
	 * @return
	 */
	public String delComments(){
		result=commentService.delComments(coNos);
		return "delComments";
	}
	/**
	 * 在视频界面添加评论信息
	 * @return
	 */
	public String shengcheng(){
		System.out.println("看到"+session.get("riuno")+session.get("richapterno"));
		Comments com=new Comments();//要添加的评论
		com.setuNo((String) session.get("riuno"));//哪个用户做的评论
		com.setChNo((String)session.get("richapterno"));//哪个章节的评论
		String images=commentBean.getCoPic();//评论的图片
		com.setCoContent(commentBean.getCoContent());//评论的内容
		String yuliu1="";//评论图片
		byte[] buffer;
		if(!"".equals(images)&&images!=null){
			yuliu1="upload/screen_" + new Date().getTime() + ".png";//对应数据库中文件的名字
			String ab=images.substring(22);
			BASE64Decoder base64=new BASE64Decoder();  
			//64位解码  
			try {
				buffer = base64.decodeBuffer(ab);
				//写进文件  创建一个向具有指定名称的文件中写入数据的输出文件流。创建一个新 FileDescriptor 对象来表示此文件连接。 
				String sdPath=ServletActionContext.getServletContext().getRealPath("");
				FileOutputStream fos=new FileOutputStream(new File(sdPath.substring(0,sdPath.lastIndexOf("\\"))+"/"+yuliu1)); 
				fos.write(buffer);  
				fos.flush();  
				fos.close();  
				fos=null; 
				//保存到数据库
				com.setCoPic(yuliu1);//添加评论图片的路径
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");//设置日期格式
				com.setCoTime(df.format(new Date()));//添加评论的时间
				result=commentService.addComment(com);
				return "shipin";
			} catch (IOException e) {
				result=0;
				return "shipin";
			} 
		}else{
			//保存到数据库
			com.setCoPic(yuliu1);//添加评论片的
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");//设置日期格式
			com.setCoTime(df.format(new Date()));//添加评论的时间
			System.out.println("套添加"+com);
			result=commentService.addComment(com);
			return "shipin";
		}
	}
	/**
	 * 在我的课程界面点击我的评论
	 * @return
	 */
	public String getCommentByUno(){
		UsersBean use=(UsersBean) session.get("loginUser");
		Users uee=new Users();
		uee.setuNo(use.getuNo());
		commentBean.setUser(uee);
		commentBean.setRows(10);
		System.out.println("wodch我的评论"+commentBean);
		session.put("comments", commentService.getAllComment(commentBean));
		session.put("myCommentTotal", commentService.getCommentTotal(commentBean));
		result=1;
		return "delComments";//借用前转为json 1的字符串

		
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
}
