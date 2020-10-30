package com.ly.cloud.user.service;

import com.ly.cloud.user.dto.TrainDTO;
import com.ly.cloud.user.entity.TrainTypeManagement;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 知识平台培训类型管理表#TrainTypeManagement# 服务接口
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-29
 */
public interface TrainTypeManagementService extends IService<TrainTypeManagement> {

	Page<TrainTypeManagement> selectPage(Page<TrainTypeManagement> page, TrainTypeManagement dto);

	boolean insertTypeAndContent(TrainDTO entity);
}
