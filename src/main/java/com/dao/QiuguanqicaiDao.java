package com.dao;

import com.entity.QiuguanqicaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QiuguanqicaiVO;
import com.entity.view.QiuguanqicaiView;


/**
 * 球馆器材
 * 
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
public interface QiuguanqicaiDao extends BaseMapper<QiuguanqicaiEntity> {
	
	List<QiuguanqicaiVO> selectListVO(@Param("ew") Wrapper<QiuguanqicaiEntity> wrapper);
	
	QiuguanqicaiVO selectVO(@Param("ew") Wrapper<QiuguanqicaiEntity> wrapper);
	
	List<QiuguanqicaiView> selectListView(@Param("ew") Wrapper<QiuguanqicaiEntity> wrapper);

	List<QiuguanqicaiView> selectListView(Pagination page,@Param("ew") Wrapper<QiuguanqicaiEntity> wrapper);

	
	QiuguanqicaiView selectView(@Param("ew") Wrapper<QiuguanqicaiEntity> wrapper);
	

}
