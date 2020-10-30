package com.ly.cloud.user.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.ly.cloud.exception.biz.BusinessException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.ly.cloud.user.entity.User;
import com.ly.cloud.user.mapper.UserMapper;
import com.ly.cloud.user.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.util.DigestUtils;

/**
 * <p>
 * 知识平台用户表#User# 服务实现类
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-20
 */
@Service
//@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final static Log logger = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	@Override
	public Page<User> selectPage(Page<User> page, User dto) {
		List<User> user = userMapper.selectPage(page, dto);
		page.setRecords(user);
		return page;
	}

	@Override
	public User selectById(Serializable id) {
		return super.selectById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean insert(User entity) {
		String password = DigestUtils.md5DigestAsHex(entity.getPassword().getBytes());  // md5加密
		entity.setPassword(password);
		entity.setUserId(UUID.randomUUID().toString()); // 为每个用户自动生成UUID
		entity.setUserStatus(BigDecimal.valueOf(1));
		User hasUser = userMapper.selectUserByYhyx(entity.getUserEmail());
		if(hasUser != null) {
			throw new BusinessException("账号已存在");
		}
		return super.insert(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean deleteById(Serializable id) {
		return super.deleteById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean updateById(User entity) {
		return super.updateById(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public User login(String yhyx , String mm){
		//校验
		User user = userMapper.selectUserByYhyxAndMM(yhyx,DigestUtils.md5DigestAsHex(mm.getBytes()));
		User hasUser = userMapper.selectUserByYhyx(yhyx);
		if(user == null){
			if(hasUser == null) {
				throw new BusinessException("账号不存在");
			}
			throw new BusinessException("密码错误");
		} else {
			if("0".equals(user.getUserStatus().toString())) {
				throw new BusinessException("账号还在审核中，请联系管理员！");
			} else if("2".equals(user.getUserStatus().toString())) {
				throw new BusinessException("账号未通过审核，请联系管理员！");
			}
		}
		return user;
	}
}
