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


import com.dao.ShouyinyuanDao;
import com.entity.ShouyinyuanEntity;
import com.service.ShouyinyuanService;
import com.entity.vo.ShouyinyuanVO;
import com.entity.view.ShouyinyuanView;

@Service("shouyinyuanService")
public class ShouyinyuanServiceImpl extends ServiceImpl<ShouyinyuanDao, ShouyinyuanEntity> implements ShouyinyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShouyinyuanEntity> page = this.selectPage(
                new Query<ShouyinyuanEntity>(params).getPage(),
                new EntityWrapper<ShouyinyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShouyinyuanEntity> wrapper) {
		  Page<ShouyinyuanView> page =new Query<ShouyinyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShouyinyuanVO> selectListVO(Wrapper<ShouyinyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShouyinyuanVO selectVO(Wrapper<ShouyinyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShouyinyuanView> selectListView(Wrapper<ShouyinyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShouyinyuanView selectView(Wrapper<ShouyinyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
