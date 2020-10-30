package com.ly.cloud.user.service;

import com.ly.cloud.user.entity.FileManagement;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 知识平台附件管理表#FileManagement# 服务接口
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-26
 */
public interface FileManagementService extends IService<FileManagement> {

	Page<FileManagement> selectPage(Page<FileManagement> page, FileManagement dto);

	List<FileManagement> queryByIds(List<String> ids);

	List<FileManagement> uploadFile(MultipartFile[] files);

	Boolean downloadFile(String id, HttpServletRequest request, HttpServletResponse response);
}
