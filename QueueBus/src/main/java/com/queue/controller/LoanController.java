package com.queue.controller;


import com.queue.entity.Loan;
import com.queue.entity.vo.LoanSearchVo;
import com.queue.service.LoanService;
import com.queue.util.PageBean;
import com.queue.util.R;
import com.queue.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
@RestController
@RequestMapping("/loan")
public class LoanController extends BaseController {

    @Autowired
    private LoanService loanService;

    @RequestMapping("/list")
    public R findList(LoanSearchVo search){
        PageBean page = new PageBean();
        List<Loan> list = this.loanService.searchByParam(search);
        page.setData(list);
        return R.okPage(page);
    }

    @RequestMapping("/save")
    public R save(Loan loan){
        loan.setCode(SecurityUtils.getUUID());
        return R.ok(this.loanService.save(loan));
    }

    @RequestMapping("/remove")
    public R delByIds(Long id){
        return R.ok(this.loanService.removeById(id));
    }
}

