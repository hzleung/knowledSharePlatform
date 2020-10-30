package com.ly.cloud.user.service;

import com.ly.cloud.user.entity.User;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 知识平台用户表#User# 服务接口
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-20
 */
@Component
public interface UserService extends IService<User> {

	Page<User> selectPage(Page<User> page, User dto);

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	User login(String yhyx, String mm);
//	boolean insert(User user);
}
