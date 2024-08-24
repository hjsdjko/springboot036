package com.entity.vo;

import com.entity.HuiyuandengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 会员等级
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
public class HuiyuandengjiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 会员折扣
	 */
	
	private Double huiyuanzhekou;
				
	
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
			
}
