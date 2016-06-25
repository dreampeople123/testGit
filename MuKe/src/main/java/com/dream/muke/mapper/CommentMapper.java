package com.dream.muke.mapper;

import java.util.List;

import com.dream.muke.entity.CommentBean;
import com.dream.muke.entity.Comments;

/**
 * 评论表映射接口
 * @author dream
 *
 */
public interface CommentMapper {
	/**
	 * 获取所有的评论信息
	 * @param commentBean
	 * @return
	 */
	public List<CommentBean> getAllComment(CommentBean commentBean);

	/**
	 * 获取当前评论的总数
	 * @param commentBean
	 * @return
	 */
	public int getCommentTotal(CommentBean commentBean);

	/**
	 * 根据章节找到评论信息
	 * @param commentBean
	 * @return
	 */
	public List<CommentBean> findCommentsByInfo(CommentBean commentBean);

	/**
	 * 删除评论信息
	 * @param coNos
	 * @return
	 */
	public int delComments(String[] coNos);
	/**
	 * 视频界面点击点赞查询评论
	 * @param com
	 * @return
	 */
	public List<CommentBean> findCommentByDian(CommentBean com);
	/**
	 * 在视频界面添加评论
	 * @param com
	 * @return
	 */
	public int addComment(Comments com);
}