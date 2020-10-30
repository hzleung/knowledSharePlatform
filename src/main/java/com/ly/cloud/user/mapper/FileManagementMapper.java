package com.ly.cloud.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ly.cloud.user.entity.FileManagement;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 知识平台附件管理表#FileManagement# Mapper 接口
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-26
 */
public interface FileManagementMapper extends BaseMapper<FileManagement> {

	List<FileManagement> queryByIds(@Param("ids") List<String> ids);

	List<FileManagement> selectPage(@Param("page")Page<FileManagement> page, @Param("dto")FileManagement dto);

	Boolean batchInsert(@Param("list") List<FileManagement> filePOS);
}
