package com.dream.muke.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;

import com.dream.muke.utils.DateUtil;

/**
 * 文件上传(用于继承)
 * @author Administrator
 *
 */
public class UploadAction {
	//处理文件上传的三个属性
	private File[] upload; //上传文件
	private String[] uploadFileName; //上传文件名
	private String[] uploadContentType; //上传文件类型

	public File[] getUpload() {
		return upload;
	}
	public void setUpload(File[] upload) {
		this.upload = upload;
	}
	public String[] getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String[] getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String upload(){
		//绝对地址
		//项目发布的位置 +upload
		String path=ServletActionContext.getServletContext().getRealPath("upload/");
		for(int i=0;i<upload.length;i++){
			try {
				//FileUtils.copyFile( upload[i],new File(path+"/"+uploadFileName[i])); //开始上传
				String fileName=""+new DateUtil().getFileName()+i; //以日期拼接i，避免上传的文件重名  注意处理后缀这里没处理
				FileUtils.copyFile( upload[i],new File(path+"/"+ fileName)); //开始上传
				LogManager.getLogger().error("文件上传成功"+path);
				
				/*
				File[] fs=new File(path).listFiles(); //取出所有的上传文件
				List<String> files=new ArrayList<String>(); //存储文件名
				for (File f:fs) {
					files.add(f.getName());
				}
				ActionContext.getContext().getSession().put("fileName", files); //将文件名写入session
				*/
			} catch (IOException e) {
				LogManager.getLogger().error(e.toString());
				return "uploadFailed";
			}
		}
		return "uploadSuccess";
	}
}
