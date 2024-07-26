package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 来访登记
 *
 * @author 
 * @email
 */
@TableName("laifangdengji")
public class LaifangdengjiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LaifangdengjiEntity() {

	}

	public LaifangdengjiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 唯一编号
     */
    @TableField(value = "laifangdengji_uuid_number")

    private String laifangdengjiUuidNumber;


    /**
     * 信访人姓名
     */
    @TableField(value = "laifangdengji_xingming")

    private String laifangdengjiXingming;


    /**
     * 信访人电话
     */
    @TableField(value = "laifangdengji_phone")

    private String laifangdengjiPhone;


    /**
     * 主要诉求
     */
    @TableField(value = "laifangdengji_suqiu_content")

    private String laifangdengjiSuqiuContent;


    /**
     * 主要事实
     */
    @TableField(value = "laifangdengji_shishi_content")

    private String laifangdengjiShishiContent;


    /**
     * 信访目的
     */
    @TableField(value = "laifangdengji_mudi_types")

    private Integer laifangdengjiMudiTypes;


    /**
     * 信访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 是否处理
     */
    @TableField(value = "laifangdengji_chuli_types")

    private Integer laifangdengjiChuliTypes;


    /**
     * 处理结果
     */
    @TableField(value = "laifangdengji_chuli_content")

    private String laifangdengjiChuliContent;


    /**
     * 处理时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "chuli_time")

    private Date chuliTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：唯一编号
	 */
    public String getLaifangdengjiUuidNumber() {
        return laifangdengjiUuidNumber;
    }
    /**
	 * 获取：唯一编号
	 */

    public void setLaifangdengjiUuidNumber(String laifangdengjiUuidNumber) {
        this.laifangdengjiUuidNumber = laifangdengjiUuidNumber;
    }
    /**
	 * 设置：信访人姓名
	 */
    public String getLaifangdengjiXingming() {
        return laifangdengjiXingming;
    }
    /**
	 * 获取：信访人姓名
	 */

    public void setLaifangdengjiXingming(String laifangdengjiXingming) {
        this.laifangdengjiXingming = laifangdengjiXingming;
    }
    /**
	 * 设置：信访人电话
	 */
    public String getLaifangdengjiPhone() {
        return laifangdengjiPhone;
    }
    /**
	 * 获取：信访人电话
	 */

    public void setLaifangdengjiPhone(String laifangdengjiPhone) {
        this.laifangdengjiPhone = laifangdengjiPhone;
    }
    /**
	 * 设置：主要诉求
	 */
    public String getLaifangdengjiSuqiuContent() {
        return laifangdengjiSuqiuContent;
    }
    /**
	 * 获取：主要诉求
	 */

    public void setLaifangdengjiSuqiuContent(String laifangdengjiSuqiuContent) {
        this.laifangdengjiSuqiuContent = laifangdengjiSuqiuContent;
    }
    /**
	 * 设置：主要事实
	 */
    public String getLaifangdengjiShishiContent() {
        return laifangdengjiShishiContent;
    }
    /**
	 * 获取：主要事实
	 */

    public void setLaifangdengjiShishiContent(String laifangdengjiShishiContent) {
        this.laifangdengjiShishiContent = laifangdengjiShishiContent;
    }
    /**
	 * 设置：信访目的
	 */
    public Integer getLaifangdengjiMudiTypes() {
        return laifangdengjiMudiTypes;
    }
    /**
	 * 获取：信访目的
	 */

    public void setLaifangdengjiMudiTypes(Integer laifangdengjiMudiTypes) {
        this.laifangdengjiMudiTypes = laifangdengjiMudiTypes;
    }
    /**
	 * 设置：信访时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：信访时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：是否处理
	 */
    public Integer getLaifangdengjiChuliTypes() {
        return laifangdengjiChuliTypes;
    }
    /**
	 * 获取：是否处理
	 */

    public void setLaifangdengjiChuliTypes(Integer laifangdengjiChuliTypes) {
        this.laifangdengjiChuliTypes = laifangdengjiChuliTypes;
    }
    /**
	 * 设置：处理结果
	 */
    public String getLaifangdengjiChuliContent() {
        return laifangdengjiChuliContent;
    }
    /**
	 * 获取：处理结果
	 */

    public void setLaifangdengjiChuliContent(String laifangdengjiChuliContent) {
        this.laifangdengjiChuliContent = laifangdengjiChuliContent;
    }
    /**
	 * 设置：处理时间
	 */
    public Date getChuliTime() {
        return chuliTime;
    }
    /**
	 * 获取：处理时间
	 */

    public void setChuliTime(Date chuliTime) {
        this.chuliTime = chuliTime;
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

    @Override
    public String toString() {
        return "Laifangdengji{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", laifangdengjiUuidNumber=" + laifangdengjiUuidNumber +
            ", laifangdengjiXingming=" + laifangdengjiXingming +
            ", laifangdengjiPhone=" + laifangdengjiPhone +
            ", laifangdengjiSuqiuContent=" + laifangdengjiSuqiuContent +
            ", laifangdengjiShishiContent=" + laifangdengjiShishiContent +
            ", laifangdengjiMudiTypes=" + laifangdengjiMudiTypes +
            ", insertTime=" + insertTime +
            ", laifangdengjiChuliTypes=" + laifangdengjiChuliTypes +
            ", laifangdengjiChuliContent=" + laifangdengjiChuliContent +
            ", chuliTime=" + chuliTime +
            ", createTime=" + createTime +
        "}";
    }
}
