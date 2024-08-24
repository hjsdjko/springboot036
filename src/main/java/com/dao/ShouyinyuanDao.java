package com.dao;

import com.entity.ShouyinyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShouyinyuanVO;
import com.entity.view.ShouyinyuanView;


/**
 * 收银员
 * 
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
public interface ShouyinyuanDao extends BaseMapper<ShouyinyuanEntity> {
	
	List<ShouyinyuanVO> selectListVO(@Param("ew") Wrapper<ShouyinyuanEntity> wrapper);
	
	ShouyinyuanVO selectVO(@Param("ew") Wrapper<ShouyinyuanEntity> wrapper);
	
	List<ShouyinyuanView> selectListView(@Param("ew") Wrapper<ShouyinyuanEntity> wrapper);

	List<ShouyinyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ShouyinyuanEntity> wrapper);

	
	ShouyinyuanView selectView(@Param("ew") Wrapper<ShouyinyuanEntity> wrapper);
	

}
