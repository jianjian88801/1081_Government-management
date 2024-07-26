package com.entity.vo;

import com.entity.HuiyishiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 会议室预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huiyishi_yuyue")
public class HuiyishiYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 会议室
     */

    @TableField(value = "huiyishi_id")
    private Integer huiyishiId;


    /**
     * 会议室预约编号
     */

    @TableField(value = "huiyishi_yuyue_uuid_number")
    private String huiyishiYuyueUuidNumber;


    /**
     * 会议室预约名称
     */

    @TableField(value = "huiyishi_yuyue_mingcheng")
    private String huiyishiYuyueMingcheng;


    /**
     * 会议室预约类型
     */

    @TableField(value = "huiyishi_yuyue_types")
    private Integer huiyishiYuyueTypes;


    /**
     * 预约内容
     */

    @TableField(value = "huiyishi_yuyue_content")
    private String huiyishiYuyueContent;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 使用开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shiyong_kaishi_time")
    private Date shiyongKaishiTime;


    /**
     * 使用结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shiyong_jieshu_time")
    private Date shiyongJieshuTime;


    /**
     * 审核状态
     */

    @TableField(value = "huiyishi_yuyue_yesno_types")
    private Integer huiyishiYuyueYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "huiyishi_yuyue_yesno_text")
    private String huiyishiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "huiyishi_yuyue_shenhe_time")
    private Date huiyishiYuyueShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：会议室
	 */
    public Integer getHuiyishiId() {
        return huiyishiId;
    }


    /**
	 * 获取：会议室
	 */

    public void setHuiyishiId(Integer huiyishiId) {
        this.huiyishiId = huiyishiId;
    }
    /**
	 * 设置：会议室预约编号
	 */
    public String getHuiyishiYuyueUuidNumber() {
        return huiyishiYuyueUuidNumber;
    }


    /**
	 * 获取：会议室预约编号
	 */

    public void setHuiyishiYuyueUuidNumber(String huiyishiYuyueUuidNumber) {
        this.huiyishiYuyueUuidNumber = huiyishiYuyueUuidNumber;
    }
    /**
	 * 设置：会议室预约名称
	 */
    public String getHuiyishiYuyueMingcheng() {
        return huiyishiYuyueMingcheng;
    }


    /**
	 * 获取：会议室预约名称
	 */

    public void setHuiyishiYuyueMingcheng(String huiyishiYuyueMingcheng) {
        this.huiyishiYuyueMingcheng = huiyishiYuyueMingcheng;
    }
    /**
	 * 设置：会议室预约类型
	 */
    public Integer getHuiyishiYuyueTypes() {
        return huiyishiYuyueTypes;
    }


    /**
	 * 获取：会议室预约类型
	 */

    public void setHuiyishiYuyueTypes(Integer huiyishiYuyueTypes) {
        this.huiyishiYuyueTypes = huiyishiYuyueTypes;
    }
    /**
	 * 设置：预约内容
	 */
    public String getHuiyishiYuyueContent() {
        return huiyishiYuyueContent;
    }


    /**
	 * 获取：预约内容
	 */

    public void setHuiyishiYuyueContent(String huiyishiYuyueContent) {
        this.huiyishiYuyueContent = huiyishiYuyueContent;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：使用开始时间
	 */
    public Date getShiyongKaishiTime() {
        return shiyongKaishiTime;
    }


    /**
	 * 获取：使用开始时间
	 */

    public void setShiyongKaishiTime(Date shiyongKaishiTime) {
        this.shiyongKaishiTime = shiyongKaishiTime;
    }
    /**
	 * 设置：使用结束时间
	 */
    public Date getShiyongJieshuTime() {
        return shiyongJieshuTime;
    }


    /**
	 * 获取：使用结束时间
	 */

    public void setShiyongJieshuTime(Date shiyongJieshuTime) {
        this.shiyongJieshuTime = shiyongJieshuTime;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getHuiyishiYuyueYesnoTypes() {
        return huiyishiYuyueYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setHuiyishiYuyueYesnoTypes(Integer huiyishiYuyueYesnoTypes) {
        this.huiyishiYuyueYesnoTypes = huiyishiYuyueYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getHuiyishiYuyueYesnoText() {
        return huiyishiYuyueYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setHuiyishiYuyueYesnoText(String huiyishiYuyueYesnoText) {
        this.huiyishiYuyueYesnoText = huiyishiYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getHuiyishiYuyueShenheTime() {
        return huiyishiYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setHuiyishiYuyueShenheTime(Date huiyishiYuyueShenheTime) {
        this.huiyishiYuyueShenheTime = huiyishiYuyueShenheTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
