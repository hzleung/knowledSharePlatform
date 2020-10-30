package com.ly.cloud.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ly.cloud.user.entity.ToolManagement;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 知识平台工具管理表#ToolManagement# Mapper 接口
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-22
 */
public interface ToolManagementMapper extends BaseMapper<ToolManagement> {

	List<ToolManagement> selectPage(@Param("page")Page<ToolManagement> page, @Param("dto")ToolManagement dto);

}
