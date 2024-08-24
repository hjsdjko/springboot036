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


import com.dao.QiuguanqicaiDao;
import com.entity.QiuguanqicaiEntity;
import com.service.QiuguanqicaiService;
import com.entity.vo.QiuguanqicaiVO;
import com.entity.view.QiuguanqicaiView;

@Service("qiuguanqicaiService")
public class QiuguanqicaiServiceImpl extends ServiceImpl<QiuguanqicaiDao, QiuguanqicaiEntity> implements QiuguanqicaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QiuguanqicaiEntity> page = this.selectPage(
                new Query<QiuguanqicaiEntity>(params).getPage(),
                new EntityWrapper<QiuguanqicaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QiuguanqicaiEntity> wrapper) {
		  Page<QiuguanqicaiView> page =new Query<QiuguanqicaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<QiuguanqicaiVO> selectListVO(Wrapper<QiuguanqicaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QiuguanqicaiVO selectVO(Wrapper<QiuguanqicaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QiuguanqicaiView> selectListView(Wrapper<QiuguanqicaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QiuguanqicaiView selectView(Wrapper<QiuguanqicaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
