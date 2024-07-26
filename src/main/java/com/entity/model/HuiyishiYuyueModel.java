package com.entity.model;

import com.entity.HuiyishiYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 会议室预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuiyishiYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 会议室
     */
    private Integer huiyishiId;


    /**
     * 会议室预约编号
     */
    private String huiyishiYuyueUuidNumber;


    /**
     * 会议室预约名称
     */
    private String huiyishiYuyueMingcheng;


    /**
     * 会议室预约类型
     */
    private Integer huiyishiYuyueTypes;


    /**
     * 预约内容
     */
    private String huiyishiYuyueContent;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 使用开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shiyongKaishiTime;


    /**
     * 使用结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shiyongJieshuTime;


    /**
     * 审核状态
     */
    private Integer huiyishiYuyueYesnoTypes;


    /**
     * 审核意见
     */
    private String huiyishiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date huiyishiYuyueShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：会议室
	 */
    public Integer getHuiyishiId() {
        return huiyishiId;
    }


    /**
	 * 设置：会议室
	 */
    public void setHuiyishiId(Integer huiyishiId) {
        this.huiyishiId = huiyishiId;
    }
    /**
	 * 获取：会议室预约编号
	 */
    public String getHuiyishiYuyueUuidNumber() {
        return huiyishiYuyueUuidNumber;
    }


    /**
	 * 设置：会议室预约编号
	 */
    public void setHuiyishiYuyueUuidNumber(String huiyishiYuyueUuidNumber) {
        this.huiyishiYuyueUuidNumber = huiyishiYuyueUuidNumber;
    }
    /**
	 * 获取：会议室预约名称
	 */
    public String getHuiyishiYuyueMingcheng() {
        return huiyishiYuyueMingcheng;
    }


    /**
	 * 设置：会议室预约名称
	 */
    public void setHuiyishiYuyueMingcheng(String huiyishiYuyueMingcheng) {
        this.huiyishiYuyueMingcheng = huiyishiYuyueMingcheng;
    }
    /**
	 * 获取：会议室预约类型
	 */
    public Integer getHuiyishiYuyueTypes() {
        return huiyishiYuyueTypes;
    }


    /**
	 * 设置：会议室预约类型
	 */
    public void setHuiyishiYuyueTypes(Integer huiyishiYuyueTypes) {
        this.huiyishiYuyueTypes = huiyishiYuyueTypes;
    }
    /**
	 * 获取：预约内容
	 */
    public String getHuiyishiYuyueContent() {
        return huiyishiYuyueContent;
    }


    /**
	 * 设置：预约内容
	 */
    public void setHuiyishiYuyueContent(String huiyishiYuyueContent) {
        this.huiyishiYuyueContent = huiyishiYuyueContent;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：使用开始时间
	 */
    public Date getShiyongKaishiTime() {
        return shiyongKaishiTime;
    }


    /**
	 * 设置：使用开始时间
	 */
    public void setShiyongKaishiTime(Date shiyongKaishiTime) {
        this.shiyongKaishiTime = shiyongKaishiTime;
    }
    /**
	 * 获取：使用结束时间
	 */
    public Date getShiyongJieshuTime() {
        return shiyongJieshuTime;
    }


    /**
	 * 设置：使用结束时间
	 */
    public void setShiyongJieshuTime(Date shiyongJieshuTime) {
        this.shiyongJieshuTime = shiyongJieshuTime;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getHuiyishiYuyueYesnoTypes() {
        return huiyishiYuyueYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setHuiyishiYuyueYesnoTypes(Integer huiyishiYuyueYesnoTypes) {
        this.huiyishiYuyueYesnoTypes = huiyishiYuyueYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getHuiyishiYuyueYesnoText() {
        return huiyishiYuyueYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setHuiyishiYuyueYesnoText(String huiyishiYuyueYesnoText) {
        this.huiyishiYuyueYesnoText = huiyishiYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getHuiyishiYuyueShenheTime() {
        return huiyishiYuyueShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setHuiyishiYuyueShenheTime(Date huiyishiYuyueShenheTime) {
        this.huiyishiYuyueShenheTime = huiyishiYuyueShenheTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
