package com.ly.cloud.user.mapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ly.cloud.user.entity.ArticleManagement;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 知识平台文章管理表#ArticleManagement# Mapper 接口
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-23
 */
public interface ArticleManagementMapper extends BaseMapper<ArticleManagement> {

	List<ArticleManagement> selectPage(@Param("page")Page<ArticleManagement> page, @Param("dto")ArticleManagement dto);

	List<ArticleManagement> queryAll();

	boolean updateArticleVisit(@Param("id") Serializable id, @Param("lll") BigDecimal lll);

	List<ArticleManagement> queryTopTen();

//	boolean updateArticleVisit(Serializable id, BigDecimal lll);
}
