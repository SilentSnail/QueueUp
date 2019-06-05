package com.queue.controller;


import com.queue.entity.vo.AuthoritySearchVo;
import com.queue.service.AuthorityService;
import com.queue.utils.PageBean;
import com.queue.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liusong
 * @since 2019-05-11
 */
@RestController
@RequestMapping("/authority")
public class AuthorityController extends BaseController {

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/search")
    public R search(AuthoritySearchVo search){
        PageBean page = new PageBean();
        page.setData(this.authorityService.searchAuthorityList(search));
        return R.okPage(page);
    }
}

