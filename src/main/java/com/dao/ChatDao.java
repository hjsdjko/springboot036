package com.dao;

import com.entity.ChatEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChatVO;
import com.entity.view.ChatView;


/**
 * 意见反馈
 * 
 * @author 
 * @email 
 * @date 2024-04-23 09:43:46
 */
public interface ChatDao extends BaseMapper<ChatEntity> {
	
	List<ChatVO> selectListVO(@Param("ew") Wrapper<ChatEntity> wrapper);
	
	ChatVO selectVO(@Param("ew") Wrapper<ChatEntity> wrapper);
	
	List<ChatView> selectListView(@Param("ew") Wrapper<ChatEntity> wrapper);

	List<ChatView> selectListView(Pagination page,@Param("ew") Wrapper<ChatEntity> wrapper);

	
	ChatView selectView(@Param("ew") Wrapper<ChatEntity> wrapper);
	

}