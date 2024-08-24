package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChangguanyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChangguanyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChangguanyuyueView;


/**
 * 场馆预约
 *
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
public interface ChangguanyuyueService extends IService<ChangguanyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChangguanyuyueVO> selectListVO(Wrapper<ChangguanyuyueEntity> wrapper);
   	
   	ChangguanyuyueVO selectVO(@Param("ew") Wrapper<ChangguanyuyueEntity> wrapper);
   	
   	List<ChangguanyuyueView> selectListView(Wrapper<ChangguanyuyueEntity> wrapper);
   	
   	ChangguanyuyueView selectView(@Param("ew") Wrapper<ChangguanyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChangguanyuyueEntity> wrapper);

   	

}

