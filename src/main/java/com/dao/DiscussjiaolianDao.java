package com.dao;

import com.entity.DiscussjiaolianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjiaolianVO;
import com.entity.view.DiscussjiaolianView;


/**
 * 教练评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-23 09:43:46
 */
public interface DiscussjiaolianDao extends BaseMapper<DiscussjiaolianEntity> {
	
	List<DiscussjiaolianVO> selectListVO(@Param("ew") Wrapper<DiscussjiaolianEntity> wrapper);
	
	DiscussjiaolianVO selectVO(@Param("ew") Wrapper<DiscussjiaolianEntity> wrapper);
	
	List<DiscussjiaolianView> selectListView(@Param("ew") Wrapper<DiscussjiaolianEntity> wrapper);

	List<DiscussjiaolianView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiaolianEntity> wrapper);

	
	DiscussjiaolianView selectView(@Param("ew") Wrapper<DiscussjiaolianEntity> wrapper);
	

}
