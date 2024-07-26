package com.entity.model;

import com.entity.LaifangdengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 来访登记
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LaifangdengjiModel implements Serializable {
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
     * 唯一编号
     */
    private String laifangdengjiUuidNumber;


    /**
     * 信访人姓名
     */
    private String laifangdengjiXingming;


    /**
     * 信访人电话
     */
    private String laifangdengjiPhone;


    /**
     * 主要诉求
     */
    private String laifangdengjiSuqiuContent;


    /**
     * 主要事实
     */
    private String laifangdengjiShishiContent;


    /**
     * 信访目的
     */
    private Integer laifangdengjiMudiTypes;


    /**
     * 信访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 是否处理
     */
    private Integer laifangdengjiChuliTypes;


    /**
     * 处理结果
     */
    private String laifangdengjiChuliContent;


    /**
     * 处理时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chuliTime;


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
	 * 获取：唯一编号
	 */
    public String getLaifangdengjiUuidNumber() {
        return laifangdengjiUuidNumber;
    }


    /**
	 * 设置：唯一编号
	 */
    public void setLaifangdengjiUuidNumber(String laifangdengjiUuidNumber) {
        this.laifangdengjiUuidNumber = laifangdengjiUuidNumber;
    }
    /**
	 * 获取：信访人姓名
	 */
    public String getLaifangdengjiXingming() {
        return laifangdengjiXingming;
    }


    /**
	 * 设置：信访人姓名
	 */
    public void setLaifangdengjiXingming(String laifangdengjiXingming) {
        this.laifangdengjiXingming = laifangdengjiXingming;
    }
    /**
	 * 获取：信访人电话
	 */
    public String getLaifangdengjiPhone() {
        return laifangdengjiPhone;
    }


    /**
	 * 设置：信访人电话
	 */
    public void setLaifangdengjiPhone(String laifangdengjiPhone) {
        this.laifangdengjiPhone = laifangdengjiPhone;
    }
    /**
	 * 获取：主要诉求
	 */
    public String getLaifangdengjiSuqiuContent() {
        return laifangdengjiSuqiuContent;
    }


    /**
	 * 设置：主要诉求
	 */
    public void setLaifangdengjiSuqiuContent(String laifangdengjiSuqiuContent) {
        this.laifangdengjiSuqiuContent = laifangdengjiSuqiuContent;
    }
    /**
	 * 获取：主要事实
	 */
    public String getLaifangdengjiShishiContent() {
        return laifangdengjiShishiContent;
    }


    /**
	 * 设置：主要事实
	 */
    public void setLaifangdengjiShishiContent(String laifangdengjiShishiContent) {
        this.laifangdengjiShishiContent = laifangdengjiShishiContent;
    }
    /**
	 * 获取：信访目的
	 */
    public Integer getLaifangdengjiMudiTypes() {
        return laifangdengjiMudiTypes;
    }


    /**
	 * 设置：信访目的
	 */
    public void setLaifangdengjiMudiTypes(Integer laifangdengjiMudiTypes) {
        this.laifangdengjiMudiTypes = laifangdengjiMudiTypes;
    }
    /**
	 * 获取：信访时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：信访时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：是否处理
	 */
    public Integer getLaifangdengjiChuliTypes() {
        return laifangdengjiChuliTypes;
    }


    /**
	 * 设置：是否处理
	 */
    public void setLaifangdengjiChuliTypes(Integer laifangdengjiChuliTypes) {
        this.laifangdengjiChuliTypes = laifangdengjiChuliTypes;
    }
    /**
	 * 获取：处理结果
	 */
    public String getLaifangdengjiChuliContent() {
        return laifangdengjiChuliContent;
    }


    /**
	 * 设置：处理结果
	 */
    public void setLaifangdengjiChuliContent(String laifangdengjiChuliContent) {
        this.laifangdengjiChuliContent = laifangdengjiChuliContent;
    }
    /**
	 * 获取：处理时间
	 */
    public Date getChuliTime() {
        return chuliTime;
    }


    /**
	 * 设置：处理时间
	 */
    public void setChuliTime(Date chuliTime) {
        this.chuliTime = chuliTime;
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
