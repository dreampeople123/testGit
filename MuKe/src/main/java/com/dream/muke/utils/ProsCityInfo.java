package com.dream.muke.utils;  

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;   
import org.dom4j.Element;   
import org.dom4j.io.SAXReader;   

/**
 * 获取省市信息
 * @author dream
 *
 */
public class ProsCityInfo  {
	
	/**
	 * 获取省信息
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,String> getPros() throws Exception{
		
		URL url=new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getRegionProvince");
		URLConnection con=url.openConnection();
		InputStream in=con.getInputStream();
		
		SAXReader reader = new SAXReader();
		Document document=reader.read(in);
		Element root = document.getRootElement();
		
		List<Element> ems=root.elements("string");
		String pro;
		Map<String,String> pros=new HashMap<String, String>();
		for (Element e : ems) {
			pro=e.getText();
			pros.put(pro.substring(0, pro.indexOf(",")), pro.substring(pro.indexOf(",")+1));
		}
		return pros;
	}
	
	/**
	 * 获取城市信息
	 * @param theRegionCode 省的编码
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getCity(String theRegionCode) throws Exception{
		
		URL url=new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getSupportCityString?theRegionCode="+theRegionCode);
		URLConnection con=url.openConnection();
		InputStream in=con.getInputStream();
		
		SAXReader reader = new SAXReader();
		Document document=reader.read(in);
		Element root = document.getRootElement();
		
		List<Element> ems=root.elements("string");
		String city;
		List<String> citys=new ArrayList<String>();
		for (Element e : ems) {
			city=e.getText();
			citys.add(city.substring(0, city.indexOf(",")));
		}
		return citys;
	}
}  
