package com.dao;

import com.entity.ChangguanyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChangguanyuyueVO;
import com.entity.view.ChangguanyuyueView;


/**
 * 场馆预约
 * 
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
public interface ChangguanyuyueDao extends BaseMapper<ChangguanyuyueEntity> {
	
	List<ChangguanyuyueVO> selectListVO(@Param("ew") Wrapper<ChangguanyuyueEntity> wrapper);
	
	ChangguanyuyueVO selectVO(@Param("ew") Wrapper<ChangguanyuyueEntity> wrapper);
	
	List<ChangguanyuyueView> selectListView(@Param("ew") Wrapper<ChangguanyuyueEntity> wrapper);

	List<ChangguanyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<ChangguanyuyueEntity> wrapper);

	
	ChangguanyuyueView selectView(@Param("ew") Wrapper<ChangguanyuyueEntity> wrapper);
	

}
