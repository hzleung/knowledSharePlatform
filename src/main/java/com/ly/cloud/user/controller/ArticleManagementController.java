package com.ly.cloud.user.controller;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.ly.cloud.common.mybatisplus.plugins.PageInfo;
import com.ly.cloud.user.entity.ArticleManagement;
import com.ly.cloud.user.service.ArticleManagementService;
import com.ly.cloud.web.utils.WebResponse;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 * 知识平台文章管理表#ArticleManagement# 前端控制器
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-23
 */
@RestController
@Api(tags = "文章管理")
@RequestMapping("articleManagement")
public class ArticleManagementController {

	private final static Log logger = LogFactory.getLog(ArticleManagementController.class);

	@Resource
	private ArticleManagementService articleManagementService;

//	@ApiOperation(value = "查询文章列表", notes = "")
//	@RequestMapping(value = "/getArticleList", method = RequestMethod.GET)
//	public WebResponse<PageInfo<ArticleManagement>> queryPage(@RequestParam int pageNum, @RequestParam int pageSize) {
//		try {
//			Page<ArticleManagement> page = articleManagementService.selectPage(new Page<ArticleManagement>(pageNum, pageSize));
//			return new WebResponse<PageInfo<ArticleManagement>>().success(PageInfo.toPageInfo(page));
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			return new WebResponse<PageInfo<ArticleManagement>>().failure(e.getMessage());
//		}
//	}

	@ApiOperation(value = "文章详情", notes = "")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public WebResponse<ArticleManagement> get(@PathVariable("id") String id) {
        try {
        	return new WebResponse<ArticleManagement>().success(articleManagementService.selectById(id));
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
			return new WebResponse<ArticleManagement>().failure(e.getMessage());
        }
	}

	@ApiOperation(value = "获取所有文章", notes = "")
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public WebResponse<List<ArticleManagement>> selectAll() {
		try {
			List<ArticleManagement> list = articleManagementService.selectAll();
			return new WebResponse<List<ArticleManagement>>().success(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<List<ArticleManagement>>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "发布文章", notes = "")
	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	public WebResponse<Boolean> add(@RequestBody ArticleManagement entity) {
		try {
			entity.setArticlePublicTime(new Date());
			entity.setArticleVisit(BigDecimal.valueOf(0));
			entity.setArticleReview(BigDecimal.valueOf(0));
			entity.setArticleLike(BigDecimal.valueOf(0));
			return new WebResponse<Boolean>().success(articleManagementService.insert(entity));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "删除文章", notes = "")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public WebResponse<Boolean> delete(@PathVariable("id") String id) {
		try {
			return new WebResponse<Boolean>().success(articleManagementService.deleteById(id));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "修改文章", notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public WebResponse<Boolean> update(@RequestBody ArticleManagement dto) {
		try {
			return new WebResponse<Boolean>().success(articleManagementService.updateById(dto));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "相关推荐", notes = "")
	@RequestMapping(value = "/recommend", method = RequestMethod.GET)
	public WebResponse<List<ArticleManagement>> selectTopTen() {
		try {
			List<ArticleManagement> list = articleManagementService.selectTopTen();
			System.out.println(list);
			return new WebResponse<List<ArticleManagement>>().success(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<List<ArticleManagement>>().failure(e.getMessage());
		}
	}

}

