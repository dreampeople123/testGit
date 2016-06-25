package com.dream.muke.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dream.muke.utils.SessionKey;

/**
 * 过滤/back的请求
 * @author Administrator
 *
 */
public class BackFilter	implements Filter {
	private String backLoginPage="backlogin/backlogin.jsp";

	public void destroy() {
		
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) servletRequest;
		HttpServletResponse response=(HttpServletResponse) servletResponse;
		
		HttpSession session=request.getSession();
		if(session.getAttribute(SessionKey.LOGIN_ADMIN)==null){ //说明没有登录
			PrintWriter out=response.getWriter();
			//获取基址路径，即到WebRoot下
			String bassPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
			out.print("<script>location.href='"+bassPath+backLoginPage+"';</script>");
			out.flush();
			out.close();
		} else{ //说明已经登录，则调用下一个过滤器过滤
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		String temp=arg0.getInitParameter("backLoginPage");
		if(temp!=null){ //说明配置了初始化页面信息
			backLoginPage=temp;
		}
	}

}
