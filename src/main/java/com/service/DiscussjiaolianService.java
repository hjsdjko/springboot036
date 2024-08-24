package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjiaolianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjiaolianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjiaolianView;


/**
 * 教练评论表
 *
 * @author 
 * @email 
 * @date 2024-04-23 09:43:46
 */
public interface DiscussjiaolianService extends IService<DiscussjiaolianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiaolianVO> selectListVO(Wrapper<DiscussjiaolianEntity> wrapper);
   	
   	DiscussjiaolianVO selectVO(@Param("ew") Wrapper<DiscussjiaolianEntity> wrapper);
   	
   	List<DiscussjiaolianView> selectListView(Wrapper<DiscussjiaolianEntity> wrapper);
   	
   	DiscussjiaolianView selectView(@Param("ew") Wrapper<DiscussjiaolianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiaolianEntity> wrapper);

   	

}

