package com.entity.view;

import com.entity.ChangguanyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 场馆预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
@TableName("changguanyuyue")
public class ChangguanyuyueView  extends ChangguanyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChangguanyuyueView(){
	}
 
 	public ChangguanyuyueView(ChangguanyuyueEntity changguanyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, changguanyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
