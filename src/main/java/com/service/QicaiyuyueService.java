package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QicaiyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QicaiyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QicaiyuyueView;


/**
 * 器材预约
 *
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
public interface QicaiyuyueService extends IService<QicaiyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QicaiyuyueVO> selectListVO(Wrapper<QicaiyuyueEntity> wrapper);
   	
   	QicaiyuyueVO selectVO(@Param("ew") Wrapper<QicaiyuyueEntity> wrapper);
   	
   	List<QicaiyuyueView> selectListView(Wrapper<QicaiyuyueEntity> wrapper);
   	
   	QicaiyuyueView selectView(@Param("ew") Wrapper<QicaiyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QicaiyuyueEntity> wrapper);

   	

}

