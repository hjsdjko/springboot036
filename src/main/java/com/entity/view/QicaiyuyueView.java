package com.entity.view;

import com.entity.QicaiyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 器材预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
@TableName("qicaiyuyue")
public class QicaiyuyueView  extends QicaiyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QicaiyuyueView(){
	}
 
 	public QicaiyuyueView(QicaiyuyueEntity qicaiyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, qicaiyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
