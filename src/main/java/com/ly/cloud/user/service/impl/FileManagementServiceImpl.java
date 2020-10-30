package com.ly.cloud.user.service.impl;

import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ly.cloud.exception.biz.BusinessException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.ly.cloud.user.entity.FileManagement;
import com.ly.cloud.user.mapper.FileManagementMapper;
import com.ly.cloud.user.service.FileManagementService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 知识平台附件管理表#FileManagement# 服务实现类
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-26
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class FileManagementServiceImpl extends ServiceImpl<FileManagementMapper, FileManagement> implements FileManagementService {

    private final static Log logger = LogFactory.getLog(FileManagementServiceImpl.class);

	@Value("${file.path}")
	private String path;

//	@Autowired
//	private HttpServletRequest request;

	@Autowired
	private FileManagementMapper fileManagementMapper;

	@Override
	public Page<FileManagement> selectPage(Page<FileManagement> page, FileManagement dto) {
		page.setRecords(fileManagementMapper.selectPage(page, dto));
		return page;
	}

	@Override
	public FileManagement selectById(Serializable id) {
		return super.selectById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean insert(FileManagement entity) {
		return super.insert(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean deleteById(Serializable id) {
		return super.deleteById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean updateById(FileManagement entity) {
		return super.updateById(entity);
	}

	@Override
	public List<FileManagement> queryByIds(List<String> ids) {
		return this.fileManagementMapper.queryByIds(ids);
	}

	@Override
	public List<FileManagement> uploadFile(MultipartFile[] files) {
		List<FileManagement> res = new ArrayList<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String filepath = path + "/" + simpleDateFormat.format(new Date());
		File filePath = new File(filepath);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		try {
			for (MultipartFile file : files) {
				FileManagement filePO = new FileManagement();
				if (StringUtils.isEmpty(file.getOriginalFilename())) {
					continue;
				}
				String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
				filePO.setFileId(UUID.randomUUID().toString());
				filePO.setFileName(file.getOriginalFilename());
//				filePO.setFileType(fileSuffix.replaceAll(".", ""));
				filePO.setFileType(fileSuffix.substring(1));
				filePO.setFileSize(new BigDecimal(file.getSize()));
				String fileName = filePO.getFileId() + fileSuffix;
				File trFile = new File(filepath + "/" + fileName);
				filePO.setFilePath(filepath + "/" + fileName);
				file.transferTo(trFile);
				res.add(filePO);
			}
			if (res.size() > 0) {
				this.fileManagementMapper.batchInsert(res);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessException("附件上传失败");
		}
		return res;
	}

	@Override
	public Boolean downloadFile(String id, HttpServletRequest request, HttpServletResponse response) {
		List<String> ids = new ArrayList<>();
		ids.add(id);
		List<FileManagement> res = this.queryByIds(ids);
		if (res.size() > 0) {
			FileManagement filePO = res.get(0);
			File file = new File(filePO.getFilePath());
			if (file.exists()) {
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				byte[] buffer = new byte[1024];
				try {
					String finalFileName = URLEncoder.encode(filePO.getFileName(), "UTF-8");
					response.setContentType("application/force-download");// 设置强制下载不打开
					response.addHeader("Content-Disposition", "attachment; filename*=utf-8'zh_cn'" + finalFileName);
//					response.setHeader("content-type", "application/octet-stream");
//					response.setContentType("application/octet-stream");
//					response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(finalFileName, "UTF-8"));
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
					System.out.println("下载成功...");
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
					throw new BusinessException("文件下载失败");
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
						}
					}
				}
			}
			return false;
		}
		return false;
	}
}
