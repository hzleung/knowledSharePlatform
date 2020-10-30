package com.ly.cloud.user.mapper;

import java.util.List;
import java.util.Map;

import com.ly.cloud.user.entity.FileManagement;
import org.apache.ibatis.annotations.Param;

import com.ly.cloud.user.entity.TrainTypeManagement;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 知识平台培训类型管理表#TrainTypeManagement# Mapper 接口
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-29
 */
public interface TrainTypeManagementMapper extends BaseMapper<TrainTypeManagement> {

	List<TrainTypeManagement> selectPage(@Param("page")Page<TrainTypeManagement> page, @Param("dto")TrainTypeManagement dto);

	Boolean trainInsert(@Param("dto") TrainTypeManagement dto);

	List<Map<String,Object>> selectAllTrain();
}
