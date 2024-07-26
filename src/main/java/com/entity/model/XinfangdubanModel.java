package com.entity.model;

import com.entity.XinfangdubanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 信访督办
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XinfangdubanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 来访登记
     */
    private Integer laifangdengjiId;


    /**
     * 督办编号
     */
    private String xinfangdubanUuidNumber;


    /**
     * 督办标题
     */
    private String xinfangdubanBiaoti;


    /**
     * 督办内容
     */
    private String xinfangdubanSuqiuContent;


    /**
     * 督办时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：来访登记
	 */
    public Integer getLaifangdengjiId() {
        return laifangdengjiId;
    }


    /**
	 * 设置：来访登记
	 */
    public void setLaifangdengjiId(Integer laifangdengjiId) {
        this.laifangdengjiId = laifangdengjiId;
    }
    /**
	 * 获取：督办编号
	 */
    public String getXinfangdubanUuidNumber() {
        return xinfangdubanUuidNumber;
    }


    /**
	 * 设置：督办编号
	 */
    public void setXinfangdubanUuidNumber(String xinfangdubanUuidNumber) {
        this.xinfangdubanUuidNumber = xinfangdubanUuidNumber;
    }
    /**
	 * 获取：督办标题
	 */
    public String getXinfangdubanBiaoti() {
        return xinfangdubanBiaoti;
    }


    /**
	 * 设置：督办标题
	 */
    public void setXinfangdubanBiaoti(String xinfangdubanBiaoti) {
        this.xinfangdubanBiaoti = xinfangdubanBiaoti;
    }
    /**
	 * 获取：督办内容
	 */
    public String getXinfangdubanSuqiuContent() {
        return xinfangdubanSuqiuContent;
    }


    /**
	 * 设置：督办内容
	 */
    public void setXinfangdubanSuqiuContent(String xinfangdubanSuqiuContent) {
        this.xinfangdubanSuqiuContent = xinfangdubanSuqiuContent;
    }
    /**
	 * 获取：督办时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：督办时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
