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

import com.entity.ChangguanyuyueEntity;
import com.entity.view.ChangguanyuyueView;

import com.service.ChangguanyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 场馆预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
@RestController
@RequestMapping("/changguanyuyue")
public class ChangguanyuyueController {
    @Autowired
    private ChangguanyuyueService changguanyuyueService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangguanyuyueEntity changguanyuyue,
                @RequestParam(required = false) Double huiyuanzhekoustart,
                @RequestParam(required = false) Double huiyuanzhekouend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			changguanyuyue.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChangguanyuyueEntity> ew = new EntityWrapper<ChangguanyuyueEntity>();
                if(huiyuanzhekoustart!=null) ew.ge("huiyuanzhekou", huiyuanzhekoustart);
                if(huiyuanzhekouend!=null) ew.le("huiyuanzhekou", huiyuanzhekouend);

		PageUtils page = changguanyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changguanyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChangguanyuyueEntity changguanyuyue, 
                @RequestParam(required = false) Double huiyuanzhekoustart,
                @RequestParam(required = false) Double huiyuanzhekouend,
		HttpServletRequest request){
        EntityWrapper<ChangguanyuyueEntity> ew = new EntityWrapper<ChangguanyuyueEntity>();
                if(huiyuanzhekoustart!=null) ew.ge("huiyuanzhekou", huiyuanzhekoustart);
                if(huiyuanzhekouend!=null) ew.le("huiyuanzhekou", huiyuanzhekouend);

		PageUtils page = changguanyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changguanyuyue), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangguanyuyueEntity changguanyuyue){
       	EntityWrapper<ChangguanyuyueEntity> ew = new EntityWrapper<ChangguanyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changguanyuyue, "changguanyuyue")); 
        return R.ok().put("data", changguanyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangguanyuyueEntity changguanyuyue){
        EntityWrapper< ChangguanyuyueEntity> ew = new EntityWrapper< ChangguanyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changguanyuyue, "changguanyuyue")); 
		ChangguanyuyueView changguanyuyueView =  changguanyuyueService.selectView(ew);
		return R.ok("查询场馆预约成功").put("data", changguanyuyueView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangguanyuyueEntity changguanyuyue = changguanyuyueService.selectById(id);
        return R.ok().put("data", changguanyuyue);
    }

    /**
     * 前台详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangguanyuyueEntity changguanyuyue = changguanyuyueService.selectById(id);
        return R.ok().put("data", changguanyuyue);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangguanyuyueEntity changguanyuyue, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(changguanyuyue);
        changguanyuyueService.insert(changguanyuyue);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangguanyuyueEntity changguanyuyue, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(changguanyuyue);
        changguanyuyueService.insert(changguanyuyue);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangguanyuyueEntity changguanyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changguanyuyue);
        changguanyuyueService.updateById(changguanyuyue);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changguanyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
