package com.dream.muke.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.Ask;
import com.dream.muke.entity.BackAskBean;

import com.dream.muke.entity.CommunityAskBean;

import com.dream.muke.entity.frontAsk;

/**
 * 回答表映射接口
 * @author dream
 *
 */
@Repository("askMapper")
public interface AskMapper {
	/**
	 * 获取问答信息(后台)
	 * @return
	 */
	public List<BackAskBean> getAskInfo(BackAskBean backAskBean);
	
	/**
	 * 根据类型找到问题信息
	 * @param typeNo
	 * @return
	 */
	public List<BackAskBean> findAskByType(BackAskBean backAskBean);

	/**
	 * 根据编号删除ask信息
	 * @param aNo
	 */
	public void delAskInfoByNo(String aNo);

	/**
	 * 获取当前的问题的数量
	 * @param backAskBean
	 * @return
	 */
	public int getAskTotal(BackAskBean backAskBean);


	/**
	 * 获取社区的问答信息
	 * @param backAskBean
	 * @return
	 */
	public List<CommunityAskBean> findCommunityAsks(BackAskBean backAskBean);

	/**
	 * 获取社区的热门问答(前三)
	 * @return
	 */
	public List<CommunityAskBean> findCommunityHotAsk();

	/**
	 * 获取社区回答雷锋榜(前三)
	 * @return
	 */
	public List<CommunityAskBean> findCommunityHotUser();

	/**
	 * 根据编号找到问题详情
	 * @param aNo
	 * @return
	 */
	public CommunityAskBean findAskBeanByNo(String aNo);

	/**
	 * 添加回答信息
	 * @param params
	 * @return
	 */
	public int addCommunityAsk(Map<String, Object> params);

	/**
	 * 查询视频界面的全部问答信息
	 * @return
	 */
	public List<frontAsk> findForntAsk(Map<String, Object> maps);
	/**
	 * 查询视频界面的精华问答信息
	 * @return
	 */
	public List<frontAsk> findJinAskByCtype(Map<String, Object> maps);
	/**
	 * 视频界面添加问答信息
	 * @param ask
	 * @return
	 */
	public int addAsk(Ask ask);
}
