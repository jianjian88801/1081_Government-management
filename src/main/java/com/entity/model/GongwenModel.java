package com.entity.model;

import com.entity.GongwenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 公文
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongwenModel implements Serializable {
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
     * 文号
     */
    private String gongwenUuidNumber;


    /**
     * 公文年号
     */
    private Integer nianhaoTypes;


    /**
     * 份号
     */
    private String gongwenFenhao;


    /**
     * 接收单位
     */
    private Integer danweiTypes;


    /**
     * 公文标题
     */
    private String gongwenName;


    /**
     * 公文附件
     */
    private String gongwenFile;


    /**
     * 公文内容
     */
    private String gongwenContent;


    /**
     * 发送时间
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
	 * 获取：文号
	 */
    public String getGongwenUuidNumber() {
        return gongwenUuidNumber;
    }


    /**
	 * 设置：文号
	 */
    public void setGongwenUuidNumber(String gongwenUuidNumber) {
        this.gongwenUuidNumber = gongwenUuidNumber;
    }
    /**
	 * 获取：公文年号
	 */
    public Integer getNianhaoTypes() {
        return nianhaoTypes;
    }


    /**
	 * 设置：公文年号
	 */
    public void setNianhaoTypes(Integer nianhaoTypes) {
        this.nianhaoTypes = nianhaoTypes;
    }
    /**
	 * 获取：份号
	 */
    public String getGongwenFenhao() {
        return gongwenFenhao;
    }


    /**
	 * 设置：份号
	 */
    public void setGongwenFenhao(String gongwenFenhao) {
        this.gongwenFenhao = gongwenFenhao;
    }
    /**
	 * 获取：接收单位
	 */
    public Integer getDanweiTypes() {
        return danweiTypes;
    }


    /**
	 * 设置：接收单位
	 */
    public void setDanweiTypes(Integer danweiTypes) {
        this.danweiTypes = danweiTypes;
    }
    /**
	 * 获取：公文标题
	 */
    public String getGongwenName() {
        return gongwenName;
    }


    /**
	 * 设置：公文标题
	 */
    public void setGongwenName(String gongwenName) {
        this.gongwenName = gongwenName;
    }
    /**
	 * 获取：公文附件
	 */
    public String getGongwenFile() {
        return gongwenFile;
    }


    /**
	 * 设置：公文附件
	 */
    public void setGongwenFile(String gongwenFile) {
        this.gongwenFile = gongwenFile;
    }
    /**
	 * 获取：公文内容
	 */
    public String getGongwenContent() {
        return gongwenContent;
    }


    /**
	 * 设置：公文内容
	 */
    public void setGongwenContent(String gongwenContent) {
        this.gongwenContent = gongwenContent;
    }
    /**
	 * 获取：发送时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发送时间
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
