package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShouyinyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShouyinyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShouyinyuanView;


/**
 * 收银员
 *
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
public interface ShouyinyuanService extends IService<ShouyinyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShouyinyuanVO> selectListVO(Wrapper<ShouyinyuanEntity> wrapper);
   	
   	ShouyinyuanVO selectVO(@Param("ew") Wrapper<ShouyinyuanEntity> wrapper);
   	
   	List<ShouyinyuanView> selectListView(Wrapper<ShouyinyuanEntity> wrapper);
   	
   	ShouyinyuanView selectView(@Param("ew") Wrapper<ShouyinyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShouyinyuanEntity> wrapper);

   	

}

