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

import com.entity.QicaiyuyueEntity;
import com.entity.view.QicaiyuyueView;

import com.service.QicaiyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 器材预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
@RestController
@RequestMapping("/qicaiyuyue")
public class QicaiyuyueController {
    @Autowired
    private QicaiyuyueService qicaiyuyueService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QicaiyuyueEntity qicaiyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			qicaiyuyue.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QicaiyuyueEntity> ew = new EntityWrapper<QicaiyuyueEntity>();

		PageUtils page = qicaiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qicaiyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QicaiyuyueEntity qicaiyuyue, 
		HttpServletRequest request){
        EntityWrapper<QicaiyuyueEntity> ew = new EntityWrapper<QicaiyuyueEntity>();

		PageUtils page = qicaiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qicaiyuyue), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QicaiyuyueEntity qicaiyuyue){
       	EntityWrapper<QicaiyuyueEntity> ew = new EntityWrapper<QicaiyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qicaiyuyue, "qicaiyuyue")); 
        return R.ok().put("data", qicaiyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QicaiyuyueEntity qicaiyuyue){
        EntityWrapper< QicaiyuyueEntity> ew = new EntityWrapper< QicaiyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qicaiyuyue, "qicaiyuyue")); 
		QicaiyuyueView qicaiyuyueView =  qicaiyuyueService.selectView(ew);
		return R.ok("查询器材预约成功").put("data", qicaiyuyueView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QicaiyuyueEntity qicaiyuyue = qicaiyuyueService.selectById(id);
        return R.ok().put("data", qicaiyuyue);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QicaiyuyueEntity qicaiyuyue = qicaiyuyueService.selectById(id);
        return R.ok().put("data", qicaiyuyue);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QicaiyuyueEntity qicaiyuyue, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(qicaiyuyue);
        qicaiyuyueService.insert(qicaiyuyue);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QicaiyuyueEntity qicaiyuyue, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(qicaiyuyue);
        qicaiyuyueService.insert(qicaiyuyue);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QicaiyuyueEntity qicaiyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qicaiyuyue);
        qicaiyuyueService.updateById(qicaiyuyue);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qicaiyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,QicaiyuyueEntity qicaiyuyue, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            qicaiyuyue.setYonghuming((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<QicaiyuyueEntity> ew = new EntityWrapper<QicaiyuyueEntity>();
        int count = qicaiyuyueService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qicaiyuyue), params), params));
        return R.ok().put("data", count);
    }



}
