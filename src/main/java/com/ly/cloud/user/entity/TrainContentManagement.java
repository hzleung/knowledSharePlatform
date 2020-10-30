package com.ly.cloud.user.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 知识平台培训内容管理表#TrainContentManagement#
 * </p>
 *
 * @author lianghaizhong
 * @since 2020-10-29
 */
@TableName("LY_LDD_PXNRGLB")
public class TrainContentManagement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 培训内容编号#trainContentId#
     */
    @TableId("PXNRBH")
	private String trainContentId;
    /**
     * 培训地点#trainPlace#
     */
	@TableField("PXDD")
	private String trainPlace;
    /**
     * 培训简介#trainProfile#
     */
	@TableField("PXJJ")
	private String trainProfile;
    /**
     * 培训开始时间#trainStartTime#
     */
	@TableField("PXKSSJ")
	private Date trainStartTime;
    /**
     * 培训发布时间#trainPublishTime#
     */
	@TableField("PXFBSJ")
	private Date trainPublishTime;
    /**
     * 培训发布用户#trainPublishUserId#
     */
	@TableField("PXFBYH")
	private String trainPublishUserId;
    /**
     * 培训发布用户头像#trainPublishUserAvatar#
     */
	@TableField("PXFBTX")
	private Object trainPublishUserAvatar;
    /**
     * 培训内容#trainContent#
     */
	@TableField("PXNR")
	private String trainContent;
    /**
     * 培训产品简称#trainProductProfile#
     */
	@TableField("PXCPJC")
	private String trainProductProfile;
    /**
     * 封面#banner#
     */
	@TableField("FM")
	private Object banner;
    /**
     * 培训视频#trainVideo#
     */
	@TableField("PXSP")
	private String trainVideo;
    /**
     * 培训附件#trainFiles#
     */
	@TableField("PXFJ")
	private String trainFiles;
    /**
     * 培训编号#trainId#
     */
	@TableField("PXBH")
	private String trainId;
	/**
	 * 培训名称#trainName#
	 */
	@TableField("PXMC")
	private String trainName;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getTrainContentId() {
		return trainContentId;
	}

	public void setTrainContentId(String trainContentId) {
		this.trainContentId = trainContentId;
	}

	public String getTrainPlace() {
		return trainPlace;
	}

	public void setTrainPlace(String trainPlace) {
		this.trainPlace = trainPlace;
	}

	public String getTrainProfile() {
		return trainProfile;
	}

	public void setTrainProfile(String trainProfile) {
		this.trainProfile = trainProfile;
	}

	public Date getTrainStartTime() {
		return trainStartTime;
	}

	public void setTrainStartTime(Date trainStartTime) {
		this.trainStartTime = trainStartTime;
	}

	public Date getTrainPublishTime() {
		return trainPublishTime;
	}

	public void setTrainPublishTime(Date trainPublishTime) {
		this.trainPublishTime = trainPublishTime;
	}

	public String getTrainPublishUserId() {
		return trainPublishUserId;
	}

	public void setTrainPublishUserId(String trainPublishUserId) {
		this.trainPublishUserId = trainPublishUserId;
	}

	public Object getTrainPublishUserAvatar() {
		return trainPublishUserAvatar;
	}

	public void setTrainPublishUserAvatar(Object trainPublishUserAvatar) {
		this.trainPublishUserAvatar = trainPublishUserAvatar;
	}

	public String getTrainContent() {
		return trainContent;
	}

	public void setTrainContent(String trainContent) {
		this.trainContent = trainContent;
	}

	public String getTrainProductProfile() {
		return trainProductProfile;
	}

	public void setTrainProductProfile(String trainProductProfile) {
		this.trainProductProfile = trainProductProfile;
	}

	public Object getBanner() {
		return banner;
	}

	public void setBanner(Object banner) {
		this.banner = banner;
	}

	public String getTrainVideo() {
		return trainVideo;
	}

	public void setTrainVideo(String trainVideo) {
		this.trainVideo = trainVideo;
	}

	public String getTrainFiles() {
		return trainFiles;
	}

	public void setTrainFiles(String trainFiles) {
		this.trainFiles = trainFiles;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	@Override
	public String toString() {
		return "TrainContentManagement{" +
				"trainContentId='" + trainContentId + '\'' +
				", trainPlace='" + trainPlace + '\'' +
				", trainProfile='" + trainProfile + '\'' +
				", trainStartTime=" + trainStartTime +
				", trainPublishTime=" + trainPublishTime +
				", trainPublishUserId='" + trainPublishUserId + '\'' +
				", trainPublishUserAvatar=" + trainPublishUserAvatar +
				", trainContent='" + trainContent + '\'' +
				", trainProductProfile='" + trainProductProfile + '\'' +
				", banner=" + banner +
				", trainVideo='" + trainVideo + '\'' +
				", trainFiles='" + trainFiles + '\'' +
				", trainId='" + trainId + '\'' +
				", trainName='" + trainName + '\'' +
				'}';
	}
}
