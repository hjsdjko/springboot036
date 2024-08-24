package com.dao;

import com.entity.QicaiyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QicaiyuyueVO;
import com.entity.view.QicaiyuyueView;


/**
 * 器材预约
 * 
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
public interface QicaiyuyueDao extends BaseMapper<QicaiyuyueEntity> {
	
	List<QicaiyuyueVO> selectListVO(@Param("ew") Wrapper<QicaiyuyueEntity> wrapper);
	
	QicaiyuyueVO selectVO(@Param("ew") Wrapper<QicaiyuyueEntity> wrapper);
	
	List<QicaiyuyueView> selectListView(@Param("ew") Wrapper<QicaiyuyueEntity> wrapper);

	List<QicaiyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<QicaiyuyueEntity> wrapper);

	
	QicaiyuyueView selectView(@Param("ew") Wrapper<QicaiyuyueEntity> wrapper);
	

}
