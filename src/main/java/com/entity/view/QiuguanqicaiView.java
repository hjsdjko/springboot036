package com.entity.view;

import com.entity.QiuguanqicaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 球馆器材
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
@TableName("qiuguanqicai")
public class QiuguanqicaiView  extends QiuguanqicaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QiuguanqicaiView(){
	}
 
 	public QiuguanqicaiView(QiuguanqicaiEntity qiuguanqicaiEntity){
 	try {
			BeanUtils.copyProperties(this, qiuguanqicaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
