package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussjiaolianDao;
import com.entity.DiscussjiaolianEntity;
import com.service.DiscussjiaolianService;
import com.entity.vo.DiscussjiaolianVO;
import com.entity.view.DiscussjiaolianView;

@Service("discussjiaolianService")
public class DiscussjiaolianServiceImpl extends ServiceImpl<DiscussjiaolianDao, DiscussjiaolianEntity> implements DiscussjiaolianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiaolianEntity> page = this.selectPage(
                new Query<DiscussjiaolianEntity>(params).getPage(),
                new EntityWrapper<DiscussjiaolianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiaolianEntity> wrapper) {
		  Page<DiscussjiaolianView> page =new Query<DiscussjiaolianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussjiaolianVO> selectListVO(Wrapper<DiscussjiaolianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjiaolianVO selectVO(Wrapper<DiscussjiaolianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjiaolianView> selectListView(Wrapper<DiscussjiaolianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiaolianView selectView(Wrapper<DiscussjiaolianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
