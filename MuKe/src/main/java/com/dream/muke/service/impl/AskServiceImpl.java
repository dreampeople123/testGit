package com.dream.muke.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dream.muke.entity.Ask;
import com.dream.muke.entity.BackAskBean;

import com.dream.muke.entity.CommunityAskBean;

import com.dream.muke.entity.frontAsk;
import com.dream.muke.mapper.AnswerMapper;
import com.dream.muke.mapper.AskMapper;
import com.dream.muke.service.AskService;

@Service("askService")
public class AskServiceImpl implements AskService {
	@Autowired
	private AskMapper askMapper;
	@Autowired
	private AnswerMapper answerMapper;

	public List<BackAskBean> getAskInfo(BackAskBean backAskBean) {
		return askMapper.getAskInfo(backAskBean);
	}

	public List<BackAskBean> findAskByType(BackAskBean backAskBean) {
		return askMapper.findAskByType(backAskBean);
	}

	@Transactional
	public void delAskInfo(String askNos) {
		String[] as=askNos.split(",");
		for (String a : as) {
			//1.先将该问题的所有回答状态改为1
			delAskAnswerByANo(a);
			//2.再将该问题的状态改为1
			delAskInfoByNo(a);
		}
	}

	/**
	 * 根据编号删除ask信息
	 * @param aNo
	 */
	@Transactional
	public void delAskInfoByNo(String aNo){
		askMapper.delAskInfoByNo(aNo);
	}

	/**
	 * 根据问题编号删除问题下的回答信息
	 * @param aNo
	 */
	@Transactional
	public void delAskAnswerByANo(String aNo){
		answerMapper.delAskAnswerByANo(aNo);
	}

	public int getAskTotal(BackAskBean backAskBean) {
		return askMapper.getAskTotal(backAskBean);
	}

	public List<CommunityAskBean> findCommunityAsks(BackAskBean backAskBean) {
		List<CommunityAskBean> asks=askMapper.findCommunityAsks(backAskBean);
		for (CommunityAskBean a : asks) {
			if(a.getAnswerNum()!=0){
				a.setAnswer(answerMapper.findNewAnswerByAno(a.getAsk().getaNo()));
			}
		}
		return asks;
	}

	public List<CommunityAskBean> findCommunityHotAsk() {
		return askMapper.findCommunityHotAsk();
	}

	public List<CommunityAskBean> findCommunityHotUser() {
		return askMapper.findCommunityHotUser();
	}

	public CommunityAskBean findAskBeanByNo(String aNo) {
		return askMapper.findAskBeanByNo(aNo);
	}

	public int addAsk(Map<String, Object> params) {
		return askMapper.addCommunityAsk(params);
	}

	/**
	 * 根据cno查询视频界面的问答信息
	 * @param cno
	 * @return
	 */
	@Override
	public List<frontAsk> findForntAsk(Map<String,Object> maps) {
		return askMapper.findForntAsk(maps);
	}
	/**
	 * 查询视频界面的精华问答信息
	 * @param cno
	 * @return
	 */
	@Override
	public List<frontAsk> findJinAskByCtype(Map<String, Object> maps) {
		return askMapper.findJinAskByCtype(maps);
	}
	/**
	 * 视频界面添加问答信息
	 * @param backAskBean
	 * @return
	 */
	@Override
	public int addAsk(Ask ask) {
		return askMapper.addAsk(ask);
	}
}
