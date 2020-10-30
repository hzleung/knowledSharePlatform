package com.ly.cloud.user.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 知识平台项目地图管理表#ProjectMapManagement#
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-22
 */
@TableName("LY_LDD_XMDTGLB")
public class ProjectMapManagement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目id#projectId#
     */
    @TableId("ID")
	private String projectId;
    /**
     * 发布时间#projectPublicTime#
     */
	@TableField("FBSJ")
	private Date projectPublicTime;
    /**
     * 发布用户#projectPublicUser#
     */
	@TableField("FBYH")
	private String projectPublicUser;
    /**
     * 项目名称#projectName#
     */
	@TableField("XMMC")
	private String projectName;
    /**
     * 项目链接#projectUrl#
     */
	@TableField("XMLJ")
	private String projectUrl;
    /**
     * 项目所属大区#projectArea#
     */
	@TableField("XMSSDQ")
	private String projectArea;
    /**
     * 项目类型#projectType#
     */
	@TableField("XMLX")
	private String projectType;
    /**
     * 项目版本号#projectVersion#
     */
	@TableField("XMBBH")
	private String projectVersion;
    /**
     * 项目附件#projectFiles#
     */
	@TableField("XMFJ")
	private Object projectFiles;
    /**
     * 项目封面#projectBanner#
     */
	@TableField("XMFM")
	private Object projectBanner;


	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Date getProjectPublicTime() {
		return projectPublicTime;
	}

	public void setProjectPublicTime(Date projectPublicTime) {
		this.projectPublicTime = projectPublicTime;
	}

	public String getProjectPublicUser() {
		return projectPublicUser;
	}

	public void setProjectPublicUser(String projectPublicUser) {
		this.projectPublicUser = projectPublicUser;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectUrl() {
		return projectUrl;
	}

	public void setProjectUrl(String projectUrl) {
		this.projectUrl = projectUrl;
	}

	public String getProjectArea() {
		return projectArea;
	}

	public void setProjectArea(String projectArea) {
		this.projectArea = projectArea;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getProjectVersion() {
		return projectVersion;
	}

	public void setProjectVersion(String projectVersion) {
		this.projectVersion = projectVersion;
	}

	public Object getProjectFiles() {
		return projectFiles;
	}

	public void setProjectFiles(Object projectFiles) {
		this.projectFiles = projectFiles;
	}

	public Object getProjectBanner() {
		return projectBanner;
	}

	public void setProjectBanner(Object projectBanner) {
		this.projectBanner = projectBanner;
	}

	@Override
	public String toString() {
		return "ProjectMapManagement{" +
			", projectId=" + projectId +
			", projectPublicTime=" + projectPublicTime +
			", projectPublicUser=" + projectPublicUser +
			", projectName=" + projectName +
			", projectUrl=" + projectUrl +
			", projectArea=" + projectArea +
			", projectType=" + projectType +
			", projectVersion=" + projectVersion +
			", projectFiles=" + projectFiles +
			", projectBanner=" + projectBanner +
			"}";
	}
}
