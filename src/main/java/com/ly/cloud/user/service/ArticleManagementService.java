package com.ly.cloud.user.service;

import com.ly.cloud.user.entity.ArticleManagement;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 知识平台文章管理表#ArticleManagement# 服务接口
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-23
 */
public interface ArticleManagementService extends IService<ArticleManagement> {

	Page<ArticleManagement> selectPage(Page<ArticleManagement> page, ArticleManagement dto);

	List<ArticleManagement> selectAll();

    List<ArticleManagement> selectTopTen();

//	boolean updateArticleVisit(Serializable id, BigDecimal visit);
}
