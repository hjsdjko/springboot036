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


import com.dao.QicaiyuyueDao;
import com.entity.QicaiyuyueEntity;
import com.service.QicaiyuyueService;
import com.entity.vo.QicaiyuyueVO;
import com.entity.view.QicaiyuyueView;

@Service("qicaiyuyueService")
public class QicaiyuyueServiceImpl extends ServiceImpl<QicaiyuyueDao, QicaiyuyueEntity> implements QicaiyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QicaiyuyueEntity> page = this.selectPage(
                new Query<QicaiyuyueEntity>(params).getPage(),
                new EntityWrapper<QicaiyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QicaiyuyueEntity> wrapper) {
		  Page<QicaiyuyueView> page =new Query<QicaiyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<QicaiyuyueVO> selectListVO(Wrapper<QicaiyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QicaiyuyueVO selectVO(Wrapper<QicaiyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QicaiyuyueView> selectListView(Wrapper<QicaiyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QicaiyuyueView selectView(Wrapper<QicaiyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
