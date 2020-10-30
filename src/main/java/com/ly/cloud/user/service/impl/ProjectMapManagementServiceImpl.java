package com.ly.cloud.user.service.impl;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.ly.cloud.user.entity.ProjectMapManagement;
import com.ly.cloud.user.mapper.ProjectMapManagementMapper;
import com.ly.cloud.user.service.ProjectMapManagementService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 知识平台项目地图管理表#ProjectMapManagement# 服务实现类
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-22
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class ProjectMapManagementServiceImpl extends ServiceImpl<ProjectMapManagementMapper, ProjectMapManagement> implements ProjectMapManagementService {

    private final static Log logger = LogFactory.getLog(ProjectMapManagementServiceImpl.class);

	@Autowired
	private ProjectMapManagementMapper projectMapManagementMapper;

	@Override
	public Page<ProjectMapManagement> selectPage(Page<ProjectMapManagement> page, ProjectMapManagement dto) {
		page.setRecords(projectMapManagementMapper.selectPage(page, dto));
		return page;
	}

	@Override
	public ProjectMapManagement selectById(Serializable id) {
		return super.selectById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean insert(ProjectMapManagement entity) {
		return super.insert(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean deleteById(Serializable id) {
		return super.deleteById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean updateById(ProjectMapManagement entity) {
		return super.updateById(entity);
	}
}
