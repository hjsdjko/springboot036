package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.QiuguanqicaiEntity;
import com.entity.view.QiuguanqicaiView;

import com.service.QiuguanqicaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 球馆器材
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
@RestController
@RequestMapping("/qiuguanqicai")
public class QiuguanqicaiController {
    @Autowired
    private QiuguanqicaiService qiuguanqicaiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QiuguanqicaiEntity qiuguanqicai,
		HttpServletRequest request){
        EntityWrapper<QiuguanqicaiEntity> ew = new EntityWrapper<QiuguanqicaiEntity>();

		PageUtils page = qiuguanqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiuguanqicai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QiuguanqicaiEntity qiuguanqicai, 
		HttpServletRequest request){
        EntityWrapper<QiuguanqicaiEntity> ew = new EntityWrapper<QiuguanqicaiEntity>();

		PageUtils page = qiuguanqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiuguanqicai), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QiuguanqicaiEntity qiuguanqicai){
       	EntityWrapper<QiuguanqicaiEntity> ew = new EntityWrapper<QiuguanqicaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qiuguanqicai, "qiuguanqicai")); 
        return R.ok().put("data", qiuguanqicaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QiuguanqicaiEntity qiuguanqicai){
        EntityWrapper< QiuguanqicaiEntity> ew = new EntityWrapper< QiuguanqicaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qiuguanqicai, "qiuguanqicai")); 
		QiuguanqicaiView qiuguanqicaiView =  qiuguanqicaiService.selectView(ew);
		return R.ok("查询球馆器材成功").put("data", qiuguanqicaiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QiuguanqicaiEntity qiuguanqicai = qiuguanqicaiService.selectById(id);
        return R.ok().put("data", qiuguanqicai);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QiuguanqicaiEntity qiuguanqicai = qiuguanqicaiService.selectById(id);
        return R.ok().put("data", qiuguanqicai);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QiuguanqicaiEntity qiuguanqicai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(qiuguanqicai);
        qiuguanqicaiService.insert(qiuguanqicai);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QiuguanqicaiEntity qiuguanqicai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(qiuguanqicai);
        qiuguanqicaiService.insert(qiuguanqicai);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QiuguanqicaiEntity qiuguanqicai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qiuguanqicai);
        qiuguanqicaiService.updateById(qiuguanqicai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qiuguanqicaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
