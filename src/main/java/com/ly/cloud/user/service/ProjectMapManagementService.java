package com.ly.cloud.user.service;

import com.ly.cloud.user.entity.ProjectMapManagement;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 知识平台项目地图管理表#ProjectMapManagement# 服务接口
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-22
 */
public interface ProjectMapManagementService extends IService<ProjectMapManagement> {

	Page<ProjectMapManagement> selectPage(Page<ProjectMapManagement> page, ProjectMapManagement dto);
	
}
