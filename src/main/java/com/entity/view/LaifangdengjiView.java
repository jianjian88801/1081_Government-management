package com.entity.view;

import com.entity.LaifangdengjiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 来访登记
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("laifangdengji")
public class LaifangdengjiView extends LaifangdengjiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 信访目的的值
		*/
		private String laifangdengjiMudiValue;
		/**
		* 是否处理的值
		*/
		private String laifangdengjiChuliValue;



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

	public LaifangdengjiView() {

	}

	public LaifangdengjiView(LaifangdengjiEntity laifangdengjiEntity) {
		try {
			BeanUtils.copyProperties(this, laifangdengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
