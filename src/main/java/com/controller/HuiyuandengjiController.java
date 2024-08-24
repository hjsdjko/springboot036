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

import com.entity.HuiyuandengjiEntity;
import com.entity.view.HuiyuandengjiView;

import com.service.HuiyuandengjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 会员等级
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
@RestController
@RequestMapping("/huiyuandengji")
public class HuiyuandengjiController {
    @Autowired
    private HuiyuandengjiService huiyuandengjiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuiyuandengjiEntity huiyuandengji,
		HttpServletRequest request){
        EntityWrapper<HuiyuandengjiEntity> ew = new EntityWrapper<HuiyuandengjiEntity>();

		PageUtils page = huiyuandengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuandengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuiyuandengjiEntity huiyuandengji, 
		HttpServletRequest request){
        EntityWrapper<HuiyuandengjiEntity> ew = new EntityWrapper<HuiyuandengjiEntity>();

		PageUtils page = huiyuandengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuandengji), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuiyuandengjiEntity huiyuandengji){
       	EntityWrapper<HuiyuandengjiEntity> ew = new EntityWrapper<HuiyuandengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huiyuandengji, "huiyuandengji")); 
        return R.ok().put("data", huiyuandengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuiyuandengjiEntity huiyuandengji){
        EntityWrapper< HuiyuandengjiEntity> ew = new EntityWrapper< HuiyuandengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huiyuandengji, "huiyuandengji")); 
		HuiyuandengjiView huiyuandengjiView =  huiyuandengjiService.selectView(ew);
		return R.ok("查询会员等级成功").put("data", huiyuandengjiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuiyuandengjiEntity huiyuandengji = huiyuandengjiService.selectById(id);
        return R.ok().put("data", huiyuandengji);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuiyuandengjiEntity huiyuandengji = huiyuandengjiService.selectById(id);
        return R.ok().put("data", huiyuandengji);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuiyuandengjiEntity huiyuandengji, HttpServletRequest request){
        if(huiyuandengjiService.selectCount(new EntityWrapper<HuiyuandengjiEntity>().eq("huiyuandengji", huiyuandengji.getHuiyuandengji()))>0) {
            return R.error("会员等级已存在");
        }
    	//ValidatorUtils.validateEntity(huiyuandengji);
        huiyuandengjiService.insert(huiyuandengji);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuiyuandengjiEntity huiyuandengji, HttpServletRequest request){
        if(huiyuandengjiService.selectCount(new EntityWrapper<HuiyuandengjiEntity>().eq("huiyuandengji", huiyuandengji.getHuiyuandengji()))>0) {
            return R.error("会员等级已存在");
        }
    	//ValidatorUtils.validateEntity(huiyuandengji);
        huiyuandengjiService.insert(huiyuandengji);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuiyuandengjiEntity huiyuandengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huiyuandengji);
        if(huiyuandengjiService.selectCount(new EntityWrapper<HuiyuandengjiEntity>().ne("id", huiyuandengji.getId()).eq("huiyuandengji", huiyuandengji.getHuiyuandengji()))>0) {
            return R.error("会员等级已存在");
        }
        huiyuandengjiService.updateById(huiyuandengji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huiyuandengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
