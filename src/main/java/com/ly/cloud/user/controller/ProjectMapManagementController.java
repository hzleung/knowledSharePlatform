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
import com.ly.cloud.user.entity.ProjectMapManagement;
import com.ly.cloud.user.service.ProjectMapManagementService;
import com.ly.cloud.web.utils.WebResponse;

/**
 * <p>
 * 知识平台项目地图管理表#ProjectMapManagement# 前端控制器
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-22
 */
@RestController
@Api(tags = "项目地图")
@RequestMapping("projectMapManagement")
public class ProjectMapManagementController {

	private final static Log logger = LogFactory.getLog(ProjectMapManagementController.class);
	
	@Resource
	private ProjectMapManagementService projectMapManagementService;

	@ApiOperation(value = "分页查询项目地图列表",notes = "")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public WebResponse<PageInfo<ProjectMapManagement>> queryPage(@RequestParam int pageNum, @RequestParam int pageSize, @ModelAttribute ProjectMapManagement dto) {
		try {
			Page<ProjectMapManagement> page = projectMapManagementService.selectPage(new Page<ProjectMapManagement>(pageNum, pageSize), dto);
			return new WebResponse<PageInfo<ProjectMapManagement>>().success(PageInfo.toPageInfo(page));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<PageInfo<ProjectMapManagement>>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "根据id查询项目",notes = "")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public WebResponse<ProjectMapManagement> get(@PathVariable("id") String id) {
        try {
        	return new WebResponse<ProjectMapManagement>().success(projectMapManagementService.selectById(id));
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
			return new WebResponse<ProjectMapManagement>().failure(e.getMessage());
        }
	}

	@ApiOperation(value = "新增项目",notes = "")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public WebResponse<Boolean> add(@RequestBody ProjectMapManagement dto) {
		try {
			return new WebResponse<Boolean>().success(projectMapManagementService.insert(dto));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "删除项目",notes = "根据id删除项目")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public WebResponse<Boolean> delete(@PathVariable("id") String id) {
		try {
			return new WebResponse<Boolean>().success(projectMapManagementService.deleteById(id));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "更新项目",notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public WebResponse<Boolean> update(@RequestBody ProjectMapManagement dto) {
		try {
			return new WebResponse<Boolean>().success(projectMapManagementService.updateById(dto));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}

}

