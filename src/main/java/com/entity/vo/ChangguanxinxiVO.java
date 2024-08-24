package com.entity.vo;

import com.entity.ChangguanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 场馆信息
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
public class ChangguanxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 场地类型
	 */
	
	private String changdileixing;
		
	/**
	 * 场馆地址
	 */
	
	private String changguandizhi;
		
	/**
	 * 联系热线
	 */
	
	private String lianxirexian;
		
	/**
	 * 容纳人数
	 */
	
	private Integer rongnarenshu;
		
	/**
	 * 场地数量
	 */
	
	private Integer changdishuliang;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 价格/元
	 */
	
	private Double jiage;
		
	/**
	 * 场馆介绍
	 */
	
	private String changguanjieshao;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
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
	 * 设置：场馆地址
	 */
	 
	public void setChangguandizhi(String changguandizhi) {
		this.changguandizhi = changguandizhi;
	}
	
	/**
	 * 获取：场馆地址
	 */
	public String getChangguandizhi() {
		return changguandizhi;
	}
				
	
	/**
	 * 设置：联系热线
	 */
	 
	public void setLianxirexian(String lianxirexian) {
		this.lianxirexian = lianxirexian;
	}
	
	/**
	 * 获取：联系热线
	 */
	public String getLianxirexian() {
		return lianxirexian;
	}
				
	
	/**
	 * 设置：容纳人数
	 */
	 
	public void setRongnarenshu(Integer rongnarenshu) {
		this.rongnarenshu = rongnarenshu;
	}
	
	/**
	 * 获取：容纳人数
	 */
	public Integer getRongnarenshu() {
		return rongnarenshu;
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
	 * 设置：价格/元
	 */
	 
	public void setJiage(Double jiage) {
		this.jiage = jiage;
	}
	
	/**
	 * 获取：价格/元
	 */
	public Double getJiage() {
		return jiage;
	}
				
	
	/**
	 * 设置：场馆介绍
	 */
	 
	public void setChangguanjieshao(String changguanjieshao) {
		this.changguanjieshao = changguanjieshao;
	}
	
	/**
	 * 获取：场馆介绍
	 */
	public String getChangguanjieshao() {
		return changguanjieshao;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
