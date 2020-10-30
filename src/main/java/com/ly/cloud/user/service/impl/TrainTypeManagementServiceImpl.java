package com.ly.cloud.user.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.ly.cloud.user.dto.TrainDTO;
import com.ly.cloud.user.entity.TrainContentManagement;
import com.ly.cloud.user.mapper.TrainContentManagementMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.ly.cloud.user.entity.TrainTypeManagement;
import com.ly.cloud.user.mapper.TrainTypeManagementMapper;
import com.ly.cloud.user.service.TrainTypeManagementService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


/**
 * <p>
 * 知识平台培训类型管理表#TrainTypeManagement# 服务实现类
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-29
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class TrainTypeManagementServiceImpl extends ServiceImpl<TrainTypeManagementMapper, TrainTypeManagement> implements TrainTypeManagementService {

    private final static Log logger = LogFactory.getLog(TrainTypeManagementServiceImpl.class);

	@Autowired
	private TrainTypeManagementMapper trainTypeManagementMapper;

	@Autowired
	private TrainContentManagementMapper trainContentManagementMapper;

	@Override
	public Page<TrainTypeManagement> selectPage(Page<TrainTypeManagement> page, TrainTypeManagement dto) {
		page.setRecords(trainTypeManagementMapper.selectPage(page, dto));
		return page;
	}

	@Override
	public TrainTypeManagement selectById(Serializable id) {
		return super.selectById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean insert(TrainTypeManagement entity) {
		return super.insert(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean deleteById(Serializable id) {
		return super.deleteById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean updateById(TrainTypeManagement entity) {
		return super.updateById(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean insertTypeAndContent(TrainDTO dto) {
		TrainTypeManagement typeManagementPo = new TrainTypeManagement();
		String pkid = UUID.randomUUID().toString();
		typeManagementPo.setTrainId(pkid);
		typeManagementPo.setTrainRouteType(dto.getTrainRouteType());
		typeManagementPo.setTrainType(dto.getTrainType());
		super.insert(typeManagementPo);

		TrainContentManagement contentManagementPo = new TrainContentManagement();
		contentManagementPo.setTrainId(pkid);
		contentManagementPo.setTrainContentId(UUID.randomUUID().toString());
		contentManagementPo.setTrainStartTime(new Date());
		contentManagementPo.setTrainContent(dto.getTrainContent());
		contentManagementPo.setBanner(dto.getBanner());
		contentManagementPo.setTrainFiles(dto.getTrainFiles());
		contentManagementPo.setTrainName(dto.getTrainName());
		contentManagementPo.setTrainPlace(dto.getTrainPlace());
		contentManagementPo.setTrainProductProfile(dto.getTrainProductProfile());
		contentManagementPo.setTrainProfile(dto.getTrainProfile());
		contentManagementPo.setTrainPublishUserId(dto.getTrainPublishUserId());
		contentManagementPo.setTrainPublishUserAvatar(dto.getTrainPublishUserAvatar());
		contentManagementPo.setTrainVideo(dto.getTrainVideo());
		trainContentManagementMapper.insert(contentManagementPo);
		return false;
	}
}
