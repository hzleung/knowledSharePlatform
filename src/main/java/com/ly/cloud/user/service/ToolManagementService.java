package com.ly.cloud.user.service;

import com.ly.cloud.user.entity.ToolManagement;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 知识平台工具管理表#ToolManagement# 服务接口
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-22
 */
public interface ToolManagementService extends IService<ToolManagement> {

	Page<ToolManagement> selectPage(Page<ToolManagement> page, ToolManagement dto);
	
}
