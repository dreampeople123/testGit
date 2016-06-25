package com.dream.muke.utils;

/**
 * 存放session的键值
 * @author dream
 *
 */
public class SessionKey {
	//编写的时候请写好备注(用文档注释 看完记得删掉这条0.0)
	
	/**
	 * 错误提示
	 */
	public static final String ERROR_MSG="errorMsg";
	
	/**
	 * 当前登录的用户
	 */
	public static final String LOGIN_USER="loginUser";
	
	/**
	 * 后台登录的用户
	 */
	public static final String LOGIN_ADMIN="loginAdmin";
	
	/**
	 * 社区的问答信息
	 */
	public static final String COMMUNITY_ASKS="communityAsks";
	
	/**
	 * 社区的为你推荐
	 * 按照关注度排行的课程
	 */
	public static final String COMMUNITY_HOTCOURSE="communityHotCourse";
	
	/**
	 * 社区的热门问答
	 */
	public static final String COMMUNITY_HOTASK="communityHotAsk";
	
	/**
	 * 社区的问答雷锋榜
	 */
	public static final String COMMUNITY_HOTUSER="communityHotUser";
	
	/**
	 * 问题详情
	 */
	public static final String QUESTION_INFO="questionInfo";
	
	/**
	 * 问题的回答
	 */
	public static final String QUESTION_ANSWERS="questionAnswers";
	
	/**
	 * 所有的课程类型
	 */
	public static final String ALLTYPES="alltypes";
}
