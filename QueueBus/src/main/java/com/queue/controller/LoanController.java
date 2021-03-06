package com.queue.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.queue.entity.Loan;
import com.queue.entity.vo.LoanSearchDetail;
import com.queue.entity.vo.LoanSearchVo;
import com.queue.service.FileRecordService;
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
    @Autowired
    private FileRecordService fileRecordService;

    /**
     * 保存或新增
     * @param loan
     * @return
     */
    @RequestMapping("/save")
    public R addEntity(Loan loan, String[] images){
        loan.setCode(SecurityEncryptUtils.getUUID());
        if (loan.getLoanType() == 0){
            loan.setAmount(loan.getAmount()*-1);
        }
//        this.loanService.saveOrUpdate(loan);
        if(loan.getIsIou() == 1){//有附件
            System.out.println(images);
//            this.fileRecordService.updateIouInfo(images, loan.getCode());
        }
        return R.ok();
    }

    @RequestMapping("/update")
    public R changeLoanByCode(Loan loan){
        return R.ok(this.loanService.updateLoanByCode(loan));
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
     * @param code
     * @return
     */
    @RequestMapping("/del")
    public R removeById(String code){
        Loan loan = this.loanService.getOne(new QueryWrapper<Loan>().eq("code", code));
        if(ObjectUtils.isEmpty(loan)){
            return R.error("无此借款单");
        }
        return R.ok(this.loanService.updateById(loan.setStatus(0)));
    }

    /**
     * 依据条件 查询借款单
     * @param search 查询条件
     * @return
     */
    @RequestMapping("/findByCode")
    public R searchByCode(LoanSearchDetail search){
        PageBean page = new PageBean();
        page.setData(this.loanService.searchByCode(search));
        return R.okPage(page);
    }
}

