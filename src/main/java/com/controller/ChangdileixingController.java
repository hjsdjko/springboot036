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

import com.entity.ChangdileixingEntity;
import com.entity.view.ChangdileixingView;

import com.service.ChangdileixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 场地类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
@RestController
@RequestMapping("/changdileixing")
public class ChangdileixingController {
    @Autowired
    private ChangdileixingService changdileixingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangdileixingEntity changdileixing,
		HttpServletRequest request){
        EntityWrapper<ChangdileixingEntity> ew = new EntityWrapper<ChangdileixingEntity>();

		PageUtils page = changdileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdileixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChangdileixingEntity changdileixing, 
		HttpServletRequest request){
        EntityWrapper<ChangdileixingEntity> ew = new EntityWrapper<ChangdileixingEntity>();

		PageUtils page = changdileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdileixing), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangdileixingEntity changdileixing){
       	EntityWrapper<ChangdileixingEntity> ew = new EntityWrapper<ChangdileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changdileixing, "changdileixing")); 
        return R.ok().put("data", changdileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangdileixingEntity changdileixing){
        EntityWrapper< ChangdileixingEntity> ew = new EntityWrapper< ChangdileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changdileixing, "changdileixing")); 
		ChangdileixingView changdileixingView =  changdileixingService.selectView(ew);
		return R.ok("查询场地类型成功").put("data", changdileixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangdileixingEntity changdileixing = changdileixingService.selectById(id);
        return R.ok().put("data", changdileixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangdileixingEntity changdileixing = changdileixingService.selectById(id);
        return R.ok().put("data", changdileixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangdileixingEntity changdileixing, HttpServletRequest request){
        if(changdileixingService.selectCount(new EntityWrapper<ChangdileixingEntity>().eq("changdileixing", changdileixing.getChangdileixing()))>0) {
            return R.error("场地类型已存在");
        }
    	//ValidatorUtils.validateEntity(changdileixing);
        changdileixingService.insert(changdileixing);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangdileixingEntity changdileixing, HttpServletRequest request){
        if(changdileixingService.selectCount(new EntityWrapper<ChangdileixingEntity>().eq("changdileixing", changdileixing.getChangdileixing()))>0) {
            return R.error("场地类型已存在");
        }
    	//ValidatorUtils.validateEntity(changdileixing);
        changdileixingService.insert(changdileixing);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangdileixingEntity changdileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdileixing);
        if(changdileixingService.selectCount(new EntityWrapper<ChangdileixingEntity>().ne("id", changdileixing.getId()).eq("changdileixing", changdileixing.getChangdileixing()))>0) {
            return R.error("场地类型已存在");
        }
        changdileixingService.updateById(changdileixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changdileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}