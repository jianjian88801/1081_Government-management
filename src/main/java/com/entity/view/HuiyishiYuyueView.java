package com.entity.view;

import com.entity.HuiyishiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 会议室预约
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huiyishi_yuyue")
public class HuiyishiYuyueView extends HuiyishiYuyueEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 会议室预约类型的值
		*/
		private String huiyishiYuyueValue;
		/**
		* 审核状态的值
		*/
		private String huiyishiYuyueYesnoValue;



		//级联表 huiyishi
			/**
			* 会议室编号
			*/
			private String huiyishiUuidNumber;
			/**
			* 会议室号
			*/
			private String huiyishiMingcheng;
			/**
			* 会议室地址
			*/
			private String huiyishiAddress;
			/**
			* 会议室类型
			*/
			private Integer huiyishiTypes;
				/**
				* 会议室类型的值
				*/
				private String huiyishiValue;
			/**
			* 会议室介绍
			*/
			private String huiyishiSuqiuContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 所在单位
			*/
			private Integer danweiTypes;
				/**
				* 所在单位的值
				*/
				private String danweiValue;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public HuiyishiYuyueView() {

	}

	public HuiyishiYuyueView(HuiyishiYuyueEntity huiyishiYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, huiyishiYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 会议室预约类型的值
			*/
			public String getHuiyishiYuyueValue() {
				return huiyishiYuyueValue;
			}
			/**
			* 设置： 会议室预约类型的值
			*/
			public void setHuiyishiYuyueValue(String huiyishiYuyueValue) {
				this.huiyishiYuyueValue = huiyishiYuyueValue;
			}
			/**
			* 获取： 审核状态的值
			*/
			public String getHuiyishiYuyueYesnoValue() {
				return huiyishiYuyueYesnoValue;
			}
			/**
			* 设置： 审核状态的值
			*/
			public void setHuiyishiYuyueYesnoValue(String huiyishiYuyueYesnoValue) {
				this.huiyishiYuyueYesnoValue = huiyishiYuyueYesnoValue;
			}














				//级联表的get和set huiyishi

					/**
					* 获取： 会议室编号
					*/
					public String getHuiyishiUuidNumber() {
						return huiyishiUuidNumber;
					}
					/**
					* 设置： 会议室编号
					*/
					public void setHuiyishiUuidNumber(String huiyishiUuidNumber) {
						this.huiyishiUuidNumber = huiyishiUuidNumber;
					}

					/**
					* 获取： 会议室号
					*/
					public String getHuiyishiMingcheng() {
						return huiyishiMingcheng;
					}
					/**
					* 设置： 会议室号
					*/
					public void setHuiyishiMingcheng(String huiyishiMingcheng) {
						this.huiyishiMingcheng = huiyishiMingcheng;
					}

					/**
					* 获取： 会议室地址
					*/
					public String getHuiyishiAddress() {
						return huiyishiAddress;
					}
					/**
					* 设置： 会议室地址
					*/
					public void setHuiyishiAddress(String huiyishiAddress) {
						this.huiyishiAddress = huiyishiAddress;
					}

					/**
					* 获取： 会议室类型
					*/
					public Integer getHuiyishiTypes() {
						return huiyishiTypes;
					}
					/**
					* 设置： 会议室类型
					*/
					public void setHuiyishiTypes(Integer huiyishiTypes) {
						this.huiyishiTypes = huiyishiTypes;
					}


						/**
						* 获取： 会议室类型的值
						*/
						public String getHuiyishiValue() {
							return huiyishiValue;
						}
						/**
						* 设置： 会议室类型的值
						*/
						public void setHuiyishiValue(String huiyishiValue) {
							this.huiyishiValue = huiyishiValue;
						}

					/**
					* 获取： 会议室介绍
					*/
					public String getHuiyishiSuqiuContent() {
						return huiyishiSuqiuContent;
					}
					/**
					* 设置： 会议室介绍
					*/
					public void setHuiyishiSuqiuContent(String huiyishiSuqiuContent) {
						this.huiyishiSuqiuContent = huiyishiSuqiuContent;
					}











				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 所在单位
					*/
					public Integer getDanweiTypes() {
						return danweiTypes;
					}
					/**
					* 设置： 所在单位
					*/
					public void setDanweiTypes(Integer danweiTypes) {
						this.danweiTypes = danweiTypes;
					}


						/**
						* 获取： 所在单位的值
						*/
						public String getDanweiValue() {
							return danweiValue;
						}
						/**
						* 设置： 所在单位的值
						*/
						public void setDanweiValue(String danweiValue) {
							this.danweiValue = danweiValue;
						}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}




}
