package com.entity.vo;

import com.entity.GongwenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 公文
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gongwen")
public class GongwenVO implements Serializable {
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
     * 文号
     */

    @TableField(value = "gongwen_uuid_number")
    private String gongwenUuidNumber;


    /**
     * 公文年号
     */

    @TableField(value = "nianhao_types")
    private Integer nianhaoTypes;


    /**
     * 份号
     */

    @TableField(value = "gongwen_fenhao")
    private String gongwenFenhao;


    /**
     * 接收单位
     */

    @TableField(value = "danwei_types")
    private Integer danweiTypes;


    /**
     * 公文标题
     */

    @TableField(value = "gongwen_name")
    private String gongwenName;


    /**
     * 公文附件
     */

    @TableField(value = "gongwen_file")
    private String gongwenFile;


    /**
     * 公文内容
     */

    @TableField(value = "gongwen_content")
    private String gongwenContent;


    /**
     * 发送时间
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
	 * 设置：文号
	 */
    public String getGongwenUuidNumber() {
        return gongwenUuidNumber;
    }


    /**
	 * 获取：文号
	 */

    public void setGongwenUuidNumber(String gongwenUuidNumber) {
        this.gongwenUuidNumber = gongwenUuidNumber;
    }
    /**
	 * 设置：公文年号
	 */
    public Integer getNianhaoTypes() {
        return nianhaoTypes;
    }


    /**
	 * 获取：公文年号
	 */

    public void setNianhaoTypes(Integer nianhaoTypes) {
        this.nianhaoTypes = nianhaoTypes;
    }
    /**
	 * 设置：份号
	 */
    public String getGongwenFenhao() {
        return gongwenFenhao;
    }


    /**
	 * 获取：份号
	 */

    public void setGongwenFenhao(String gongwenFenhao) {
        this.gongwenFenhao = gongwenFenhao;
    }
    /**
	 * 设置：接收单位
	 */
    public Integer getDanweiTypes() {
        return danweiTypes;
    }


    /**
	 * 获取：接收单位
	 */

    public void setDanweiTypes(Integer danweiTypes) {
        this.danweiTypes = danweiTypes;
    }
    /**
	 * 设置：公文标题
	 */
    public String getGongwenName() {
        return gongwenName;
    }


    /**
	 * 获取：公文标题
	 */

    public void setGongwenName(String gongwenName) {
        this.gongwenName = gongwenName;
    }
    /**
	 * 设置：公文附件
	 */
    public String getGongwenFile() {
        return gongwenFile;
    }


    /**
	 * 获取：公文附件
	 */

    public void setGongwenFile(String gongwenFile) {
        this.gongwenFile = gongwenFile;
    }
    /**
	 * 设置：公文内容
	 */
    public String getGongwenContent() {
        return gongwenContent;
    }


    /**
	 * 获取：公文内容
	 */

    public void setGongwenContent(String gongwenContent) {
        this.gongwenContent = gongwenContent;
    }
    /**
	 * 设置：发送时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发送时间
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
