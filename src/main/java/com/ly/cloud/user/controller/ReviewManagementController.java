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
import com.ly.cloud.user.entity.ReviewManagement;
import com.ly.cloud.user.service.ReviewManagementService;
import com.ly.cloud.web.utils.WebResponse;

/**
 * <p>
 * 知识平台评论管理表#ReviewManagement# 前端控制器
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-23
 */
@RestController
@Api(tags = "评论管理")
@RequestMapping("reviewManagement")
public class ReviewManagementController {

	private final static Log logger = LogFactory.getLog(ReviewManagementController.class);
	
	@Resource
	private ReviewManagementService reviewManagementService;

	@ApiOperation(value = "查询评论列表", notes = "")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public WebResponse<PageInfo<ReviewManagement>> queryPage(@RequestParam int pageNum, @RequestParam int pageSize, @ModelAttribute ReviewManagement dto) {
		try {
			Page<ReviewManagement> page = reviewManagementService.selectPage(new Page<ReviewManagement>(pageNum, pageSize), dto);
			return new WebResponse<PageInfo<ReviewManagement>>().success(PageInfo.toPageInfo(page));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<PageInfo<ReviewManagement>>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "根据id查询评论", notes = "")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public WebResponse<ReviewManagement> get(@PathVariable("id") String id) {
        try {
        	return new WebResponse<ReviewManagement>().success(reviewManagementService.selectById(id));
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
			return new WebResponse<ReviewManagement>().failure(e.getMessage());
        }
	}

	@ApiOperation(value = "新增评论", notes = "")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public WebResponse<Boolean> add(@RequestBody ReviewManagement dto) {
		try {
			return new WebResponse<Boolean>().success(reviewManagementService.insert(dto));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "根据id删除评论", notes = "")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public WebResponse<Boolean> delete(@PathVariable("id") String id) {
		try {
			return new WebResponse<Boolean>().success(reviewManagementService.deleteById(id));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "修改评论", notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public WebResponse<Boolean> update(@RequestBody ReviewManagement dto) {
		try {
			return new WebResponse<Boolean>().success(reviewManagementService.updateById(dto));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}

}

