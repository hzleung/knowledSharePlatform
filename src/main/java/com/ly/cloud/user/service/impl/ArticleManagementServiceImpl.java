package com.ly.cloud.user.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.ly.cloud.user.entity.ArticleManagement;
import com.ly.cloud.user.mapper.ArticleManagementMapper;
import com.ly.cloud.user.mapper.LikeManagementMapper;
import com.ly.cloud.user.service.ArticleManagementService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 知识平台文章管理表#ArticleManagement# 服务实现类
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-23
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class ArticleManagementServiceImpl extends ServiceImpl<ArticleManagementMapper, ArticleManagement> implements ArticleManagementService {

    private final static Log logger = LogFactory.getLog(ArticleManagementServiceImpl.class);

	@Autowired
	private ArticleManagementMapper articleManagementMapper;

	@Autowired
	private LikeManagementMapper likeManagementMapper;

	@Override
	public Page<ArticleManagement> selectPage(Page<ArticleManagement> page, ArticleManagement dto) {
		page.setRecords(articleManagementMapper.selectPage(page, dto));
		return page;
	}

	@Override
	public ArticleManagement selectById(Serializable id) {
		ArticleManagement entity = super.selectById(id);
		Long visit = Long.valueOf(entity.getArticleVisit().toString());
		BigDecimal lll = BigDecimal.valueOf(visit+1);
		articleManagementMapper.updateArticleVisit(id, lll);
		return entity;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean insert(ArticleManagement entity) {
		return super.insert(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean deleteById(Serializable id) {
		return super.deleteById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean updateById(ArticleManagement entity) {
		return super.updateById(entity);
	}

	@Override
	public List<ArticleManagement> selectAll() {
		return articleManagementMapper.queryAll();
	}

	@Override
	public List<ArticleManagement> selectTopTen() {
		return articleManagementMapper.queryTopTen();
	}

//	@Override
//	public boolean updateArticleVisit(Serializable id, BigDecimal lll) {
//		return articleManagementMapper.updateArticleVisit(id, lll);
//	}
}
