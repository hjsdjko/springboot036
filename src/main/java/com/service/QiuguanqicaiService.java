package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QiuguanqicaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QiuguanqicaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QiuguanqicaiView;


/**
 * 球馆器材
 *
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
public interface QiuguanqicaiService extends IService<QiuguanqicaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QiuguanqicaiVO> selectListVO(Wrapper<QiuguanqicaiEntity> wrapper);
   	
   	QiuguanqicaiVO selectVO(@Param("ew") Wrapper<QiuguanqicaiEntity> wrapper);
   	
   	List<QiuguanqicaiView> selectListView(Wrapper<QiuguanqicaiEntity> wrapper);
   	
   	QiuguanqicaiView selectView(@Param("ew") Wrapper<QiuguanqicaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QiuguanqicaiEntity> wrapper);

   	

}

