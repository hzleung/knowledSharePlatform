package com.ly.cloud.user.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.util.Date;

/**
 * @author: lianghaizhong
 * @mail: lianghaizhong@ly-sky.com
 * @since 2020/10/29 18:02
 */


public class TrainDTO {

    private String trainId;  // 培训编号

    private String trainName; // 培训标题

    private String trainType;  // 培训类型

    private String trainRouteType;  // 培训路线类型

    private String trainContentId;  // 培训内容id

    private String trainPlace;  // 培训地点

    private String trainProfile;  // 培训简称

    private Date trainStartTime;  // 培训开始时间

    private Date trainPublishTime;  // 培训发布时间

    private String trainPublishUserId;  // 培训发布用户id

    private Object trainPublishUserAvatar;  // 培训发布用户头像

    private String trainContent;  // 培训内容

    private String trainProductProfile;  // 培训产品简称

    private Object banner;  // 封面

    private String trainVideo;  // 培训视频

    private String trainFiles;  // 培训附件

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

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getTrainRouteType() {
        return trainRouteType;
    }

    public void setTrainRouteType(String trainRouteType) {
        this.trainRouteType = trainRouteType;
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
}
