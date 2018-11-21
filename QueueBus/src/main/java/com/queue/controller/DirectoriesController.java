package com.queue.controller;


import com.queue.entity.Directories;
import com.queue.entity.vo.DirectorSearchVo;
import com.queue.service.DirectoriesService;
import com.queue.utils.PageBean;
import com.queue.utils.R;
import com.queue.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liusong
 * @since 2018-11-07
 */
@RestController
@RequestMapping("/director")
public class DirectoriesController extends BaseController {

    @Autowired
    private DirectoriesService directoriesService;

    @RequestMapping("/save")
    public R save(Directories dire){
        if(ObjectUtils.isEmpty(dire.getId())){
            dire.setUserCode(ShiroUtils.getLoginUser().getUserCode());
        }
        return R.ok(this.directoriesService.saveOrUpdate(dire));
    }

    @RequestMapping("/search")
    public R getList(DirectorSearchVo search){
        PageBean page = new PageBean();
        page.setData(this.directoriesService.findBySearchVo(search));
        return R.okPage(page);
    }

    @RequestMapping("/findById")
    public R searchById(Long id){
        Map<String, Object> result = new HashMap();
        result.put("direInfo", this.directoriesService.getById(id));
        return R.ok(result);
    }

    @RequestMapping("/del")
    public R delDirectorByCode(String code){
        this.directoriesService.delByCode(code);
        return R.ok();
    }
}

