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

import com.entity.DiscussjiaolianEntity;
import com.entity.view.DiscussjiaolianView;

import com.service.DiscussjiaolianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 教练评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-23 09:43:46
 */
@RestController
@RequestMapping("/discussjiaolian")
public class DiscussjiaolianController {
    @Autowired
    private DiscussjiaolianService discussjiaolianService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjiaolianEntity discussjiaolian,
		HttpServletRequest request){
        EntityWrapper<DiscussjiaolianEntity> ew = new EntityWrapper<DiscussjiaolianEntity>();

		PageUtils page = discussjiaolianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiaolian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjiaolianEntity discussjiaolian, 
		HttpServletRequest request){
        EntityWrapper<DiscussjiaolianEntity> ew = new EntityWrapper<DiscussjiaolianEntity>();

		PageUtils page = discussjiaolianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiaolian), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjiaolianEntity discussjiaolian){
       	EntityWrapper<DiscussjiaolianEntity> ew = new EntityWrapper<DiscussjiaolianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjiaolian, "discussjiaolian")); 
        return R.ok().put("data", discussjiaolianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjiaolianEntity discussjiaolian){
        EntityWrapper< DiscussjiaolianEntity> ew = new EntityWrapper< DiscussjiaolianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjiaolian, "discussjiaolian")); 
		DiscussjiaolianView discussjiaolianView =  discussjiaolianService.selectView(ew);
		return R.ok("查询教练评论表成功").put("data", discussjiaolianView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjiaolianEntity discussjiaolian = discussjiaolianService.selectById(id);
        return R.ok().put("data", discussjiaolian);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjiaolianEntity discussjiaolian = discussjiaolianService.selectById(id);
        return R.ok().put("data", discussjiaolian);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussjiaolianEntity discussjiaolian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjiaolian);
        discussjiaolianService.insert(discussjiaolian);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjiaolianEntity discussjiaolian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjiaolian);
        discussjiaolianService.insert(discussjiaolian);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussjiaolianEntity discussjiaolian = discussjiaolianService.selectOne(new EntityWrapper<DiscussjiaolianEntity>().eq("", username));
        return R.ok().put("data", discussjiaolian);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussjiaolianEntity discussjiaolian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjiaolian);
        discussjiaolianService.updateById(discussjiaolian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussjiaolianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussjiaolianEntity discussjiaolian, HttpServletRequest request,String pre){
        EntityWrapper<DiscussjiaolianEntity> ew = new EntityWrapper<DiscussjiaolianEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussjiaolianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiaolian), params), params));
        return R.ok().put("data", page);
    }










}
