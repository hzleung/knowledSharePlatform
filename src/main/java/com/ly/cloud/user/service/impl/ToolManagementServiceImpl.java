package com.ly.cloud.user.service.impl;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.ly.cloud.user.entity.ToolManagement;
import com.ly.cloud.user.mapper.ToolManagementMapper;
import com.ly.cloud.user.service.ToolManagementService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 知识平台工具管理表#ToolManagement# 服务实现类
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-22
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class ToolManagementServiceImpl extends ServiceImpl<ToolManagementMapper, ToolManagement> implements ToolManagementService {

    private final static Log logger = LogFactory.getLog(ToolManagementServiceImpl.class);

	@Autowired
	private ToolManagementMapper toolManagementMapper;

	@Override
	public Page<ToolManagement> selectPage(Page<ToolManagement> page, ToolManagement dto) {
		page.setRecords(toolManagementMapper.selectPage(page, dto));
		return page;
	}

	@Override
	public ToolManagement selectById(Serializable id) {
		return super.selectById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean insert(ToolManagement entity) {
		return super.insert(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean deleteById(Serializable id) {
		return super.deleteById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean updateById(ToolManagement entity) {
		return super.updateById(entity);
	}
}
