package com.entity.view;

import com.entity.XinfangdubanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 信访督办
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xinfangduban")
public class XinfangdubanView extends XinfangdubanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 laifangdengji
			/**
			* 来访登记 的 用户
			*/
			private Integer laifangdengjiYonghuId;
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
				* 信访目的的值
				*/
				private String laifangdengjiMudiValue;
			/**
			* 是否处理
			*/
			private Integer laifangdengjiChuliTypes;
				/**
				* 是否处理的值
				*/
				private String laifangdengjiChuliValue;
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

	public XinfangdubanView() {

	}

	public XinfangdubanView(XinfangdubanEntity xinfangdubanEntity) {
		try {
			BeanUtils.copyProperties(this, xinfangdubanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

















				//级联表的get和set laifangdengji

					/**
					* 获取：来访登记 的 用户
					*/
					public Integer getLaifangdengjiYonghuId() {
						return laifangdengjiYonghuId;
					}
					/**
					* 设置：来访登记 的 用户
					*/
					public void setLaifangdengjiYonghuId(Integer laifangdengjiYonghuId) {
						this.laifangdengjiYonghuId = laifangdengjiYonghuId;
					}


					/**
					* 获取： 唯一编号
					*/
					public String getLaifangdengjiUuidNumber() {
						return laifangdengjiUuidNumber;
					}
					/**
					* 设置： 唯一编号
					*/
					public void setLaifangdengjiUuidNumber(String laifangdengjiUuidNumber) {
						this.laifangdengjiUuidNumber = laifangdengjiUuidNumber;
					}

					/**
					* 获取： 信访人姓名
					*/
					public String getLaifangdengjiXingming() {
						return laifangdengjiXingming;
					}
					/**
					* 设置： 信访人姓名
					*/
					public void setLaifangdengjiXingming(String laifangdengjiXingming) {
						this.laifangdengjiXingming = laifangdengjiXingming;
					}

					/**
					* 获取： 信访人电话
					*/
					public String getLaifangdengjiPhone() {
						return laifangdengjiPhone;
					}
					/**
					* 设置： 信访人电话
					*/
					public void setLaifangdengjiPhone(String laifangdengjiPhone) {
						this.laifangdengjiPhone = laifangdengjiPhone;
					}

					/**
					* 获取： 主要诉求
					*/
					public String getLaifangdengjiSuqiuContent() {
						return laifangdengjiSuqiuContent;
					}
					/**
					* 设置： 主要诉求
					*/
					public void setLaifangdengjiSuqiuContent(String laifangdengjiSuqiuContent) {
						this.laifangdengjiSuqiuContent = laifangdengjiSuqiuContent;
					}

					/**
					* 获取： 主要事实
					*/
					public String getLaifangdengjiShishiContent() {
						return laifangdengjiShishiContent;
					}
					/**
					* 设置： 主要事实
					*/
					public void setLaifangdengjiShishiContent(String laifangdengjiShishiContent) {
						this.laifangdengjiShishiContent = laifangdengjiShishiContent;
					}

					/**
					* 获取： 信访目的
					*/
					public Integer getLaifangdengjiMudiTypes() {
						return laifangdengjiMudiTypes;
					}
					/**
					* 设置： 信访目的
					*/
					public void setLaifangdengjiMudiTypes(Integer laifangdengjiMudiTypes) {
						this.laifangdengjiMudiTypes = laifangdengjiMudiTypes;
					}


						/**
						* 获取： 信访目的的值
						*/
						public String getLaifangdengjiMudiValue() {
							return laifangdengjiMudiValue;
						}
						/**
						* 设置： 信访目的的值
						*/
						public void setLaifangdengjiMudiValue(String laifangdengjiMudiValue) {
							this.laifangdengjiMudiValue = laifangdengjiMudiValue;
						}

					/**
					* 获取： 是否处理
					*/
					public Integer getLaifangdengjiChuliTypes() {
						return laifangdengjiChuliTypes;
					}
					/**
					* 设置： 是否处理
					*/
					public void setLaifangdengjiChuliTypes(Integer laifangdengjiChuliTypes) {
						this.laifangdengjiChuliTypes = laifangdengjiChuliTypes;
					}


						/**
						* 获取： 是否处理的值
						*/
						public String getLaifangdengjiChuliValue() {
							return laifangdengjiChuliValue;
						}
						/**
						* 设置： 是否处理的值
						*/
						public void setLaifangdengjiChuliValue(String laifangdengjiChuliValue) {
							this.laifangdengjiChuliValue = laifangdengjiChuliValue;
						}

					/**
					* 获取： 处理结果
					*/
					public String getLaifangdengjiChuliContent() {
						return laifangdengjiChuliContent;
					}
					/**
					* 设置： 处理结果
					*/
					public void setLaifangdengjiChuliContent(String laifangdengjiChuliContent) {
						this.laifangdengjiChuliContent = laifangdengjiChuliContent;
					}

					/**
					* 获取： 处理时间
					*/
					public Date getChuliTime() {
						return chuliTime;
					}
					/**
					* 设置： 处理时间
					*/
					public void setChuliTime(Date chuliTime) {
						this.chuliTime = chuliTime;
					}






}
