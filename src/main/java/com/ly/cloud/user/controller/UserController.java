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
import com.ly.cloud.user.entity.User;
import com.ly.cloud.user.service.UserService;
import com.ly.cloud.web.utils.WebResponse;

/**
 * <p>
 * 知识平台用户表#User# 前端控制器
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-20
 */
@RestController
@Api(tags = "登录/注册/用户操作")
@RequestMapping("user")
public class UserController {

	private final static Log logger = LogFactory.getLog(UserController.class);
	
	@Resource
	private UserService userService;

	@ApiOperation(value = "分页查询用户信息列表",notes = "")
	@RequestMapping(value = "", method = RequestMethod.GET)

	public WebResponse<PageInfo<User>> queryPage(@RequestParam int pageNum, @RequestParam int pageSize, @ModelAttribute User dto) {
		try {
			Page<User> page = userService.selectPage(new Page<User>(pageNum, pageSize), dto);
			return new WebResponse<PageInfo<User>>().success(PageInfo.toPageInfo(page));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<PageInfo<User>>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "根据id查询用户",notes = "")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public WebResponse<User> get(@PathVariable("id") String id) {
        try {
        	return new WebResponse<User>().success(userService.selectById(id));
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
			return new WebResponse<User>().failure(e.getMessage());
        }
	}

	@ApiOperation(value = "注册",notes = "")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public WebResponse<Boolean> register(@RequestBody User dto) {
		try {
			return new WebResponse<Boolean>().success(userService.insert(dto));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "登录",notes = "")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public WebResponse<User> login(@RequestBody User dto) {
		try {
			String yhyx = dto.getUserEmail();
			String mm = dto.getPassword();
			return new WebResponse<User>().success(userService.login(yhyx, mm));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<User>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "删除用户",notes = "根据id删除用户")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public WebResponse<Boolean> delete(@PathVariable("id") String id) {
		try {
			return new WebResponse<Boolean>().success(userService.deleteById(id));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}

	@ApiOperation(value = "更新当前用户信息",notes = "")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public WebResponse<Boolean> update(@RequestBody User dto) {
		try {
			return new WebResponse<Boolean>().success(userService.updateById(dto));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new WebResponse<Boolean>().failure(e.getMessage());
		}
	}

}

