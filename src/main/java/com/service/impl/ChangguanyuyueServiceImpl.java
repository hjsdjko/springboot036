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


import com.dao.ChangguanyuyueDao;
import com.entity.ChangguanyuyueEntity;
import com.service.ChangguanyuyueService;
import com.entity.vo.ChangguanyuyueVO;
import com.entity.view.ChangguanyuyueView;

@Service("changguanyuyueService")
public class ChangguanyuyueServiceImpl extends ServiceImpl<ChangguanyuyueDao, ChangguanyuyueEntity> implements ChangguanyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChangguanyuyueEntity> page = this.selectPage(
                new Query<ChangguanyuyueEntity>(params).getPage(),
                new EntityWrapper<ChangguanyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChangguanyuyueEntity> wrapper) {
		  Page<ChangguanyuyueView> page =new Query<ChangguanyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChangguanyuyueVO> selectListVO(Wrapper<ChangguanyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChangguanyuyueVO selectVO(Wrapper<ChangguanyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChangguanyuyueView> selectListView(Wrapper<ChangguanyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChangguanyuyueView selectView(Wrapper<ChangguanyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
