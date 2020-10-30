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
import com.ly.cloud.user.entity.TrainTypeManagement;
import com.ly.cloud.user.service.TrainTypeManagementService;
import com.ly.cloud.user.dto.TrainDTO;
import com.ly.cloud.web.utils.WebResponse;

/**
 * <p>
 * 知识平台培训类型管理表#TrainTypeManagement# 前端控制器
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-29
 */
@RestController
@Api(tags = "培训管理")
@RequestMapping("trainTypeManagement")
public class TrainTypeManagementController {

	private final static Log logger = LogFactory.getLog(TrainTypeManagementController.class);
	
	@Resource
	private TrainTypeManagementService trainTypeManagementService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public WebResponse<PageInfo<TrainTypeManagement>> queryPage(@RequestParam int pageNum, @RequestParam int pageSize, @ModelAttribute TrainTypeManagement dto) {
		try {
			Page<TrainTypeManagement> page = trainTypeManagementService.selectPage(new Page<TrainTypeManagement>(pageNum, pageSize), dto);
			return new WebResponse<PageInfo<TrainTypeManagement>>().success(PageInfo.toPageInfo(page));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<PageInfo<TrainTypeManagement>>().failure(e.getMessage());
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public WebResponse<TrainTypeManagement> get(@PathVariable("id") String id) {
        try {
        	return new WebResponse<TrainTypeManagement>().success(trainTypeManagementService.selectById(id));
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
			return new WebResponse<TrainTypeManagement>().failure(e.getMessage());
        }
	}

	@ApiOperation(value = "发布", notes = "")
	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	public WebResponse<Boolean> add(@RequestBody TrainDTO dto) {
		try {
			return new WebResponse<Boolean>().success(trainTypeManagementService.insertTypeAndContent(dto));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public WebResponse<Boolean> delete(@PathVariable("id") String id) {
		try {
			return new WebResponse<Boolean>().success(trainTypeManagementService.deleteById(id));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public WebResponse<Boolean> update(@RequestBody TrainTypeManagement dto) {
		try {
			return new WebResponse<Boolean>().success(trainTypeManagementService.updateById(dto));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}

}

