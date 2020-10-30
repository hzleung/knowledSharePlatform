package com.ly.cloud.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ly.cloud.user.entity.ProjectMapManagement;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 知识平台项目地图管理表#ProjectMapManagement# Mapper 接口
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-22
 */
public interface ProjectMapManagementMapper extends BaseMapper<ProjectMapManagement> {

	List<ProjectMapManagement> selectPage(@Param("page")Page<ProjectMapManagement> page, @Param("dto")ProjectMapManagement dto);

}
