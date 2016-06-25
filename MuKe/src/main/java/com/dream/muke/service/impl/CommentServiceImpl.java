package com.dream.muke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dream.muke.entity.CommentBean;
import com.dream.muke.entity.Comments;
import com.dream.muke.mapper.CommentMapper;
import com.dream.muke.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;

	public List<CommentBean> getAllComment(CommentBean commentBean) {
		return commentMapper.getAllComment(commentBean);
	}

	public int getCommentTotal(CommentBean commentBean) {
		return commentMapper.getCommentTotal(commentBean);
	}

	public List<CommentBean> findCommentsByInfo(CommentBean commentBean) {
		return commentMapper.findCommentsByInfo(commentBean);
	}

	@Transactional
	public int delComments(String coNos) {
		return commentMapper.delComments(coNos.split(","));
	}
	/**
	 * 视频界面点击点赞查询评论
	 * @param com
	 * @return
	 */
	@Override
	public List<CommentBean> findCommentByDian(CommentBean com) {
		return  commentMapper.findCommentByDian(com);
	}
	/**
	 * 在视频界面添加评论
	 * @param com
	 * @return
	 */
	@Override
	public int addComment(Comments com) {
		return  commentMapper.addComment(com);
	}
}
