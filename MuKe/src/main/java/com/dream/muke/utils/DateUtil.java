package com.dream.muke.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取时间的工具
 * @author dream
 *
 */
public class DateUtil {
	private Date d=new Date();
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private SimpleDateFormat fn=new SimpleDateFormat("yyyyMMddHHmmssSS");
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public String getDate(){
		String date = "";
		date=sdf.format(d);
		return date;
	}
	
	/**
	 * 取文件名
	 * @return
	 */
	public String getFileName(){
		String date = "";
		date=fn.format(d);
		return date;
	}
}
