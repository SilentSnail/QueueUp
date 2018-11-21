package com.queue.controller;


import com.queue.entity.Loan;
import com.queue.entity.vo.LoanSearchVo;
import com.queue.service.LoanService;
import com.queue.utils.PageBean;
import com.queue.utils.R;
import com.queue.utils.SecurityEncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liusong
 * @since 2018-11-20
 */
@RestController
@RequestMapping("/loan")
public class LoanController extends BaseController{

    @Autowired
    private LoanService loanService;

    /**
     * 保存或新增
     * @param loan
     * @return
     */
    @RequestMapping("/save")
    public R addEntity(Loan loan){
        if(ObjectUtils.isEmpty(loan.getId())){
            loan.setCode(SecurityEncryptUtils.getUUID());
        }
        if (loan.getLoanType() == 0){
            loan.setAmount(loan.getAmount()*-1);
        }
        this.loanService.saveOrUpdate(loan);
        if(loan.getIsIou() == 1){//有附件
            System.out.println(loan.getId());
            System.out.println(loan.getCode());
        }
        return R.ok();
    }

    /**
     * 依据条件查询
     * @param search
     * @return
     */
    @RequestMapping("/list")
    public R searchList(LoanSearchVo search){
        PageBean page = new PageBean();
        page.setData(this.loanService.searchByParam(search));
        return R.okPage(page);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public R removeById(Long id){
        return R.ok(this.loanService.updateById(this.loanService.getById(id).setStatus(0)));
    }
}

