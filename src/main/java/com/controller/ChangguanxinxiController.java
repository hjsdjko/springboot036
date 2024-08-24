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

import com.entity.ChangguanxinxiEntity;
import com.entity.view.ChangguanxinxiView;

import com.service.ChangguanxinxiService;
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
 * 场馆信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-23 09:43:45
 */
@RestController
@RequestMapping("/changguanxinxi")
public class ChangguanxinxiController {
    @Autowired
    private ChangguanxinxiService changguanxinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangguanxinxiEntity changguanxinxi,
		HttpServletRequest request){
        EntityWrapper<ChangguanxinxiEntity> ew = new EntityWrapper<ChangguanxinxiEntity>();

		PageUtils page = changguanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changguanxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChangguanxinxiEntity changguanxinxi, 
		HttpServletRequest request){
        EntityWrapper<ChangguanxinxiEntity> ew = new EntityWrapper<ChangguanxinxiEntity>();

		PageUtils page = changguanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changguanxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangguanxinxiEntity changguanxinxi){
       	EntityWrapper<ChangguanxinxiEntity> ew = new EntityWrapper<ChangguanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changguanxinxi, "changguanxinxi")); 
        return R.ok().put("data", changguanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangguanxinxiEntity changguanxinxi){
        EntityWrapper< ChangguanxinxiEntity> ew = new EntityWrapper< ChangguanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changguanxinxi, "changguanxinxi")); 
		ChangguanxinxiView changguanxinxiView =  changguanxinxiService.selectView(ew);
		return R.ok("查询场馆信息成功").put("data", changguanxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangguanxinxiEntity changguanxinxi = changguanxinxiService.selectById(id);
		changguanxinxi.setClicknum(changguanxinxi.getClicknum()+1);
		changguanxinxi.setClicktime(new Date());
		changguanxinxiService.updateById(changguanxinxi);
        changguanxinxi = changguanxinxiService.selectView(new EntityWrapper<ChangguanxinxiEntity>().eq("id", id));
        return R.ok().put("data", changguanxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangguanxinxiEntity changguanxinxi = changguanxinxiService.selectById(id);
		changguanxinxi.setClicknum(changguanxinxi.getClicknum()+1);
		changguanxinxi.setClicktime(new Date());
		changguanxinxiService.updateById(changguanxinxi);
        changguanxinxi = changguanxinxiService.selectView(new EntityWrapper<ChangguanxinxiEntity>().eq("id", id));
        return R.ok().put("data", changguanxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangguanxinxiEntity changguanxinxi, HttpServletRequest request){
        if(changguanxinxiService.selectCount(new EntityWrapper<ChangguanxinxiEntity>().eq("changguanmingcheng", changguanxinxi.getChangguanmingcheng()))>0) {
            return R.error("场馆名称已存在");
        }
    	//ValidatorUtils.validateEntity(changguanxinxi);
        changguanxinxiService.insert(changguanxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangguanxinxiEntity changguanxinxi, HttpServletRequest request){
        if(changguanxinxiService.selectCount(new EntityWrapper<ChangguanxinxiEntity>().eq("changguanmingcheng", changguanxinxi.getChangguanmingcheng()))>0) {
            return R.error("场馆名称已存在");
        }
    	//ValidatorUtils.validateEntity(changguanxinxi);
        changguanxinxiService.insert(changguanxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangguanxinxiEntity changguanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changguanxinxi);
        if(changguanxinxiService.selectCount(new EntityWrapper<ChangguanxinxiEntity>().ne("id", changguanxinxi.getId()).eq("changguanmingcheng", changguanxinxi.getChangguanmingcheng()))>0) {
            return R.error("场馆名称已存在");
        }
        changguanxinxiService.updateById(changguanxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changguanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ChangguanxinxiEntity changguanxinxi, HttpServletRequest request,String pre){
        EntityWrapper<ChangguanxinxiEntity> ew = new EntityWrapper<ChangguanxinxiEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = changguanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changguanxinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ChangguanxinxiEntity changguanxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "changdileixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "changguanxinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ChangguanxinxiEntity> changguanxinxiList = new ArrayList<ChangguanxinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                changguanxinxiList.addAll(changguanxinxiService.selectList(new EntityWrapper<ChangguanxinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<ChangguanxinxiEntity> ew = new EntityWrapper<ChangguanxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = changguanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changguanxinxi), params), params));
        List<ChangguanxinxiEntity> pageList = (List<ChangguanxinxiEntity>)page.getList();
        if(changguanxinxiList.size()<limit) {
            int toAddNum = (limit-changguanxinxiList.size())<=pageList.size()?(limit-changguanxinxiList.size()):pageList.size();
            for(ChangguanxinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(ChangguanxinxiEntity o2 : changguanxinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    changguanxinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(changguanxinxiList.size()>limit) {
            changguanxinxiList = changguanxinxiList.subList(0, limit);
        }
        page.setList(changguanxinxiList);
        return R.ok().put("data", page);
    }








}
