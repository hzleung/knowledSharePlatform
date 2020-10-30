package com.ly.cloud.user.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 知识平台工具管理表#ToolManagement#
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-22
 */
@TableName("LY_LDD_GJGLB")
public class ToolManagement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工具id#toolId#
     */
    @TableId("ID")
	private String toolId;
    /**
     * 发布时间#toolPublicTime#
     */
	@TableField("FBSJ")
	private Date toolPublicTime;
    /**
     * 发布用户#toolPublicUser#
     */
	@TableField("FBYH")
	private String toolPublicUser;
    /**
     * 工具名称#toolName#
     */
	@TableField("GJMC")
	private String toolName;
    /**
     * 工具链接#toolUrl#
     */
	@TableField("GJLJ")
	private String toolUrl;
    /**
     * 工具附件#toolFile#
     */
	@TableField("GJFJ")
	private Object toolFile;


	public String getToolId() {
		return toolId;
	}

	public void setToolId(String toolId) {
		this.toolId = toolId;
	}

	public Date getToolPublicTime() {
		return toolPublicTime;
	}

	public void setToolPublicTime(Date toolPublicTime) {
		this.toolPublicTime = toolPublicTime;
	}

	public String getToolPublicUser() {
		return toolPublicUser;
	}

	public void setToolPublicUser(String toolPublicUser) {
		this.toolPublicUser = toolPublicUser;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public String getToolUrl() {
		return toolUrl;
	}

	public void setToolUrl(String toolUrl) {
		this.toolUrl = toolUrl;
	}

	public Object getToolFile() {
		return toolFile;
	}

	public void setToolFile(Object toolFile) {
		this.toolFile = toolFile;
	}

	@Override
	public String toString() {
		return "ToolManagement{" +
			", toolId=" + toolId +
			", toolPublicTime=" + toolPublicTime +
			", toolPublicUser=" + toolPublicUser +
			", toolName=" + toolName +
			", toolUrl=" + toolUrl +
			", toolFile=" + toolFile +
			"}";
	}
}
