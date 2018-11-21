package com.queue.controller;


import com.queue.entity.Directories;
import com.queue.entity.dto.DirectorDto;
import com.queue.entity.vo.DirectorSearchVo;
import com.queue.service.DirectoriesService;
import com.queue.service.LoanService;
import com.queue.utils.DateUtils;
import com.queue.utils.PageBean;
import com.queue.utils.R;
import com.queue.utils.SecurityEncryptUtils;
import org.apache.shiro.util.StringUtils;
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
    @Autowired
    private LoanService loanService;

    @RequestMapping("/save")
    public R save(Directories dire){
        dire.setUserCode(SecurityEncryptUtils.getUUID());
        if(StringUtils.hasText(dire.getIdCard())){//生日依据身份证号设置
            dire.setBirthday(DateUtils.parseDate(dire.getIdCard().substring(6, 14), "yyyyMMdd"));
        }
        return R.ok(this.directoriesService.saveOrUpdate(dire));
    }

    @RequestMapping("/update")
    public R changeByCode(Directories dire){
        if(StringUtils.hasText(dire.getIdCard())){//生日依据身份证号设置
            dire.setBirthday(DateUtils.parseDate(dire.getIdCard().substring(6, 14), "yyyyMMdd"));
        }
        return R.ok(this.directoriesService.updateDireByCode(dire));
    }

    @RequestMapping("/search")
    public R searchByParam(DirectorSearchVo search){
        PageBean page = new PageBean();
        page.setData(this.directoriesService.findBySearchVo(search));
        return R.okPage(page);
    }

    @RequestMapping("/findByCode")
    public R searchByCode(String code){
        Map<String, Object> result = new HashMap();
        DirectorDto dire = this.directoriesService.searchByCode(code);
        if(!ObjectUtils.isEmpty(dire.getBirthday())){
            dire.setAge(DateUtils.getDateDifference(dire.getBirthday(), "Y"));//计算年龄
        }
        result.put("direInfo", dire);
        result.put("amount", this.loanService.getFundingCount(dire.getId()));
        return R.ok(result);
    }

    @RequestMapping("/findInfo")
    public R searchInfoByCode(String code){
        return R.ok(this.directoriesService.searchByCode(code));
    }

    @RequestMapping("/delByCode")
    public R delDirectorByCode(String code){
        this.directoriesService.delByCode(code);
        return R.ok();
    }
}

