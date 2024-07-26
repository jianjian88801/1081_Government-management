package com.entity.vo;

import com.entity.XinfangdubanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 信访督办
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xinfangduban")
public class XinfangdubanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 来访登记
     */

    @TableField(value = "laifangdengji_id")
    private Integer laifangdengjiId;


    /**
     * 督办编号
     */

    @TableField(value = "xinfangduban_uuid_number")
    private String xinfangdubanUuidNumber;


    /**
     * 督办标题
     */

    @TableField(value = "xinfangduban_biaoti")
    private String xinfangdubanBiaoti;


    /**
     * 督办内容
     */

    @TableField(value = "xinfangduban_suqiu_content")
    private String xinfangdubanSuqiuContent;


    /**
     * 督办时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：来访登记
	 */
    public Integer getLaifangdengjiId() {
        return laifangdengjiId;
    }


    /**
	 * 获取：来访登记
	 */

    public void setLaifangdengjiId(Integer laifangdengjiId) {
        this.laifangdengjiId = laifangdengjiId;
    }
    /**
	 * 设置：督办编号
	 */
    public String getXinfangdubanUuidNumber() {
        return xinfangdubanUuidNumber;
    }


    /**
	 * 获取：督办编号
	 */

    public void setXinfangdubanUuidNumber(String xinfangdubanUuidNumber) {
        this.xinfangdubanUuidNumber = xinfangdubanUuidNumber;
    }
    /**
	 * 设置：督办标题
	 */
    public String getXinfangdubanBiaoti() {
        return xinfangdubanBiaoti;
    }


    /**
	 * 获取：督办标题
	 */

    public void setXinfangdubanBiaoti(String xinfangdubanBiaoti) {
        this.xinfangdubanBiaoti = xinfangdubanBiaoti;
    }
    /**
	 * 设置：督办内容
	 */
    public String getXinfangdubanSuqiuContent() {
        return xinfangdubanSuqiuContent;
    }


    /**
	 * 获取：督办内容
	 */

    public void setXinfangdubanSuqiuContent(String xinfangdubanSuqiuContent) {
        this.xinfangdubanSuqiuContent = xinfangdubanSuqiuContent;
    }
    /**
	 * 设置：督办时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：督办时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
