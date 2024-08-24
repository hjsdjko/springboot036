package com.entity.vo;

import com.entity.ChangguanyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 场馆预约
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
public class ChangguanyuyueVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 场馆名称
	 */
	
	private String changguanmingcheng;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 场地类型
	 */
	
	private String changdileixing;
		
	/**
	 * 场地数量
	 */
	
	private Integer changdishuliang;
		
	/**
	 * 容纳人数
	 */
	
	private String rongnarenshu;
		
	/**
	 * 预约时长
	 */
	
	private Integer yuyueshizhang;
		
	/**
	 * 价格
	 */
	
	private Double jiage;
		
	/**
	 * 会员折扣
	 */
	
	private Double huiyuanzhekou;
		
	/**
	 * 实付金额
	 */
	
	private Double shifujine;
		
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
	 * 设置：场馆名称
	 */
	 
	public void setChangguanmingcheng(String changguanmingcheng) {
		this.changguanmingcheng = changguanmingcheng;
	}
	
	/**
	 * 获取：场馆名称
	 */
	public String getChangguanmingcheng() {
		return changguanmingcheng;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：场地类型
	 */
	 
	public void setChangdileixing(String changdileixing) {
		this.changdileixing = changdileixing;
	}
	
	/**
	 * 获取：场地类型
	 */
	public String getChangdileixing() {
		return changdileixing;
	}
				
	
	/**
	 * 设置：场地数量
	 */
	 
	public void setChangdishuliang(Integer changdishuliang) {
		this.changdishuliang = changdishuliang;
	}
	
	/**
	 * 获取：场地数量
	 */
	public Integer getChangdishuliang() {
		return changdishuliang;
	}
				
	
	/**
	 * 设置：容纳人数
	 */
	 
	public void setRongnarenshu(String rongnarenshu) {
		this.rongnarenshu = rongnarenshu;
	}
	
	/**
	 * 获取：容纳人数
	 */
	public String getRongnarenshu() {
		return rongnarenshu;
	}
				
	
	/**
	 * 设置：预约时长
	 */
	 
	public void setYuyueshizhang(Integer yuyueshizhang) {
		this.yuyueshizhang = yuyueshizhang;
	}
	
	/**
	 * 获取：预约时长
	 */
	public Integer getYuyueshizhang() {
		return yuyueshizhang;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setJiage(Double jiage) {
		this.jiage = jiage;
	}
	
	/**
	 * 获取：价格
	 */
	public Double getJiage() {
		return jiage;
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
	 * 设置：实付金额
	 */
	 
	public void setShifujine(Double shifujine) {
		this.shifujine = shifujine;
	}
	
	/**
	 * 获取：实付金额
	 */
	public Double getShifujine() {
		return shifujine;
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
