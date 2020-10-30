package com.ly.cloud.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ly.cloud.user.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 知识平台用户表#User# Mapper 接口
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-20
 */
public interface UserMapper extends BaseMapper<User> {

	List<User> selectPage(@Param("page")Page<User> page, @Param("dto")User dto);
	User selectUserByYhyxAndMM (@Param("yhyx") String yhyx,@Param("mm") String mm);
	User selectUserByYhyx (@Param("yhyx") String yhyx);
}
