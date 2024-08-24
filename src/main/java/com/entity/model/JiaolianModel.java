package com.entity.model;

import com.entity.JiaolianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 教练
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
public class JiaolianModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 主教课程
	 */
	
	private String zhujiaokecheng;
		
	/**
	 * 教龄
	 */
	
	private String jiaoling;
		
	/**
	 * 每时价格
	 */
	
	private Double meishijiage;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 个人荣誉
	 */
	
	private String gerenrongyu;
		
	/**
	 * 工作经验
	 */
	
	private String gongzuojingyan;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
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
	 * 设置：教龄
	 */
	 
	public void setJiaoling(String jiaoling) {
		this.jiaoling = jiaoling;
	}
	
	/**
	 * 获取：教龄
	 */
	public String getJiaoling() {
		return jiaoling;
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
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
				
	
	/**
	 * 设置：个人荣誉
	 */
	 
	public void setGerenrongyu(String gerenrongyu) {
		this.gerenrongyu = gerenrongyu;
	}
	
	/**
	 * 获取：个人荣誉
	 */
	public String getGerenrongyu() {
		return gerenrongyu;
	}
				
	
	/**
	 * 设置：工作经验
	 */
	 
	public void setGongzuojingyan(String gongzuojingyan) {
		this.gongzuojingyan = gongzuojingyan;
	}
	
	/**
	 * 获取：工作经验
	 */
	public String getGongzuojingyan() {
		return gongzuojingyan;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
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
