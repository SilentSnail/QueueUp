package com.queue.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.queue.entity.Permissions;
import com.queue.entity.dto.PermissionDto;
import com.queue.entity.vo.PermissionSaveVo;
import com.queue.entity.vo.PermissionSearchVo;
import com.queue.service.PermissionsService;
import com.queue.utils.PageBean;
import com.queue.utils.R;
import com.queue.utils.SecurityEncryptUtils;
import com.queue.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liusong
 * @since 2019-04-23
 */
@RestController
@RequestMapping("/permissions")
public class PermissionsController {

    @Autowired
    private PermissionsService permissionsService;

    /**
     * 查询
     * @param search
     * @return
     */
    @RequestMapping("/list")
    public R getPermissionList(PermissionSearchVo search){
        PageBean page = new PageBean();
        page.setData(this.permissionsService.searchListByParam(search));
        return R.okPage(page);
    }

    /**
     * 查询节点信息 排除自身
     * @param name
     * @return
     */
    @RequestMapping("/getBaseId")
    public R searchBaseId(String name){
        PageBean page = new PageBean();
        page.setData(this.permissionsService.searchListByName(name));
        return R.okPage(page);
    }

    /**
     * 保存
     * @param permissions
     * @return
     */
    @RequestMapping("/save")
    public R savePermission(Permissions permissions){
        permissions.setCode(SecurityEncryptUtils.getUUID());
        permissions.setCreator(ShiroUtils.getLoginUser().getUsername());
        return R.ok(this.permissionsService.save(permissions));
    }

    /**
     * 依据编码查询对象
     * @param code
     * @return
     */
    @RequestMapping("/searchByCode")
    public R getPermissionByCode(String code){
        PermissionDto pms = this.permissionsService.getPrmsInfoByCode(code);
        if(ObjectUtils.isEmpty(pms)){
            return R.error("资源编码错误");
        }
        return R.ok(pms);
    }

    /**
     * 更新
     * @param change
     * @return
     */
    @RequestMapping("/changeInfo")
    public R changePmsByCode(PermissionSaveVo change){
        Permissions pms = this.permissionsService.getOne(new QueryWrapper<Permissions>().eq("code", change.getCode()));
        if(ObjectUtils.isEmpty(pms)){
            return R.error("资源编码错误");
        }
        pms.setUpdateTime(LocalDateTime.now());
        pms.setReviser(ShiroUtils.getLoginUser().getUsername());
        pms.setName(change.getName());
        pms.setParentId(change.getParentId());
        pms.setUrl(change.getUrl());
        pms.setDescribeInf(change.getDescribeInf());
        if (this.permissionsService.updateById(pms)){
            return R.ok();
        } else {
            return R.error("更新失败");
        }
    }

    /**
     * 删除
     * @param code
     * @return
     */
    @RequestMapping("/delByCode")
    public R delPermissionByCode(String code){
        Permissions pms = this.permissionsService.getOne(new QueryWrapper<Permissions>().eq("code", code));
        if(ObjectUtils.isEmpty(pms)){
            return R.error("资源编码错误");
        }
        pms.setDelStatus(true);
        this.permissionsService.updateById(pms);
        return R.ok("删除成功");
    }
}

