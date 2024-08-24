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

import com.entity.JiaolianEntity;
import com.entity.view.JiaolianView;

import com.service.JiaolianService;
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
 * 教练
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
@RestController
@RequestMapping("/jiaolian")
public class JiaolianController {
    @Autowired
    private JiaolianService jiaolianService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaolianEntity jiaolian,
		HttpServletRequest request){
        EntityWrapper<JiaolianEntity> ew = new EntityWrapper<JiaolianEntity>();

		PageUtils page = jiaolianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaolianEntity jiaolian, 
		HttpServletRequest request){
        EntityWrapper<JiaolianEntity> ew = new EntityWrapper<JiaolianEntity>();

		PageUtils page = jiaolianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolian), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaolianEntity jiaolian){
       	EntityWrapper<JiaolianEntity> ew = new EntityWrapper<JiaolianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaolian, "jiaolian")); 
        return R.ok().put("data", jiaolianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaolianEntity jiaolian){
        EntityWrapper< JiaolianEntity> ew = new EntityWrapper< JiaolianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaolian, "jiaolian")); 
		JiaolianView jiaolianView =  jiaolianService.selectView(ew);
		return R.ok("查询教练成功").put("data", jiaolianView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaolianEntity jiaolian = jiaolianService.selectById(id);
        return R.ok().put("data", jiaolian);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaolianEntity jiaolian = jiaolianService.selectById(id);
        return R.ok().put("data", jiaolian);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaolianEntity jiaolian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiaolian);
        jiaolianService.insert(jiaolian);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaolianEntity jiaolian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiaolian);
        jiaolianService.insert(jiaolian);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaolianEntity jiaolian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaolian);
        jiaolianService.updateById(jiaolian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaolianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,JiaolianEntity jiaolian, HttpServletRequest request){
        EntityWrapper<JiaolianEntity> ew = new EntityWrapper<JiaolianEntity>();
        int count = jiaolianService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolian), params), params));
        return R.ok().put("data", count);
    }



}
