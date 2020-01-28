package com.queue.controller;


import com.alibaba.fastjson.JSON;
import com.queue.entity.ForageType;
import com.queue.entity.vo.ForageTypeSearchVo;
import com.queue.service.ForageTypeService;
import com.queue.utils.*;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liusong
 * @since 2019-06-18
 */
@RestController
@RequestMapping("/forageType")
public class ForageTypeController {

    @Autowired
    private ForageTypeService forageTypeService;

    @RequestMapping("/find")
    public R findByParam(ForageTypeSearchVo param){
        PageBean page = new PageBean();
        page.setData(this.forageTypeService.fandByParam(param));
        return R.okPage(page);
    }

    @RequestMapping("/getByCode")
    public R getByCode(String code){
        Map result = new HashMap();
        ForageType forageType = this.forageTypeService.getById(code);
        if(StringUtils.hasLength(forageType.getParentCode())){
            result.put("parentCode", forageType.getParentCode());
            String parentName = this.forageTypeService.getById(forageType.getParentCode()).getForageName();
            result.put("parentName", parentName);
        }
        result.put("name", forageType.getForageName());
        result.put("status", forageType.getStatus());
        result.put("typeLevel", forageType.getTypeLevel());
        return R.ok(JSON.toJSONString(result));
    }

    @RequestMapping("/add")
    private R saveForageInfo(String forageName, String parentCode, Integer typeLevel){
        ForageType forageType = new ForageType();
        forageType.setCode(SecurityEncryptUtils.getUUID());
        forageType.setForageName(forageName);
        forageType.setParentCode(parentCode);
        forageType.setTypeLevel(typeLevel);
        forageType.setCreator(ShiroUtils.getLoginUser().getUsername());
        return R.ok(this.forageTypeService.save(forageType));
    }

    @RequestMapping("/change")
    private R changeForageByInfo(String code, String parentId, String name, Integer status, Integer typeLevel){
        ForageType forageType = this.forageTypeService.getById(code);
        Asserts.isNull(forageType, "未知类型");
        forageType.setParentCode(parentId);
        forageType.setForageName(name);
        forageType.setStatus(status);
        forageType.setTypeLevel(typeLevel);
        forageType.setUpdateTime(LocalDateTime.now());
        forageType.setUpdator(ShiroUtils.getLoginUser().getUsername());
        this.forageTypeService.updateById(forageType);
        return R.ok();
    }

    @RequestMapping("/delByCode")
    private R delForageByCode(String code){
        ForageType forageType = this.forageTypeService.getById(code);
        forageType.setDelStatus(true);
        String username = ShiroUtils.getLoginUser().getUsername();
        if(StringUtils.hasLength(username)){
            forageType.setUpdator(username);
            forageType.setUpdateTime(LocalDateTime.now());
            return R.ok(this.forageTypeService.updateById(forageType));
        }
        return R.error("未获取到用户信息");
    }
}

