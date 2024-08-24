package com.entity.model;

import com.entity.YuyuejiaolianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 预约教练
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
public class YuyuejiaolianModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 教练姓名
	 */
	
	private String jiaolianxingming;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 主教课程
	 */
	
	private String zhujiaokecheng;
		
	/**
	 * 每时价格
	 */
	
	private Double meishijiage;
		
	/**
	 * 预约时长
	 */
	
	private Double yuyueshizhang;
		
	/**
	 * 会员折扣
	 */
	
	private Double huiyuanzhekou;
		
	/**
	 * 总金额
	 */
	
	private Double zongjine;
		
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 预约时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date yuyueshijian;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
	/**
	 * 设置：教练姓名
	 */
	 
	public void setJiaolianxingming(String jiaolianxingming) {
		this.jiaolianxingming = jiaolianxingming;
	}
	
	/**
	 * 获取：教练姓名
	 */
	public String getJiaolianxingming() {
		return jiaolianxingming;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：主教课程
	 */
	 
	public void setZhujiaokecheng(String zhujiaokecheng) {
		this.zhujiaokecheng = zhujiaokecheng;
	}
	
	/**
	 * 获取：主教课程
	 */
	public String getZhujiaokecheng() {
		return zhujiaokecheng;
	}
				
	
	/**
	 * 设置：每时价格
	 */
	 
	public void setMeishijiage(Double meishijiage) {
		this.meishijiage = meishijiage;
	}
	
	/**
	 * 获取：每时价格
	 */
	public Double getMeishijiage() {
		return meishijiage;
	}
				
	
	/**
	 * 设置：预约时长
	 */
	 
	public void setYuyueshizhang(Double yuyueshizhang) {
		this.yuyueshizhang = yuyueshizhang;
	}
	
	/**
	 * 获取：预约时长
	 */
	public Double getYuyueshizhang() {
		return yuyueshizhang;
	}
				
	
	/**
	 * 设置：会员折扣
	 */
	 
	public void setHuiyuanzhekou(Double huiyuanzhekou) {
		this.huiyuanzhekou = huiyuanzhekou;
	}
	
	/**
	 * 获取：会员折扣
	 */
	public Double getHuiyuanzhekou() {
		return huiyuanzhekou;
	}
				
	
	/**
	 * 设置：总金额
	 */
	 
	public void setZongjine(Double zongjine) {
		this.zongjine = zongjine;
	}
	
	/**
	 * 获取：总金额
	 */
	public Double getZongjine() {
		return zongjine;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
				
	
	/**
	 * 设置：预约时间
	 */
	 
	public void setYuyueshijian(Date yuyueshijian) {
		this.yuyueshijian = yuyueshijian;
	}
	
	/**
	 * 获取：预约时间
	 */
	public Date getYuyueshijian() {
		return yuyueshijian;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
