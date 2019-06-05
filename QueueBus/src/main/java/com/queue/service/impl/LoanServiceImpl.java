package com.queue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.queue.entity.Loan;
import com.queue.entity.dto.LoanDto;
import com.queue.entity.dto.LoanListDto;
import com.queue.entity.vo.LoanSearchDetail;
import com.queue.entity.vo.LoanSearchVo;
import com.queue.mapper.LoanMapper;
import com.queue.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusong
 * @since 2018-11-20
 */
@Service
public class LoanServiceImpl extends ServiceImpl<LoanMapper, Loan> implements LoanService {

    @Autowired
    private LoanMapper loanMapper;

    @Override
    public List<LoanListDto> searchByParam(LoanSearchVo search) {
        return this.loanMapper.searchByParam(search);
    }

    @Override
    public boolean updateLoanByCode(Loan loan) {
        Integer count = this.loanMapper.updateLoanByCode(loan);
        if(count == 1){
            return true;
        }
        return false;
    }

    @Override
    public List<LoanDto> searchByCode(LoanSearchDetail search) {
        return this.loanMapper.searchByCode(search);
    }

    @Override
    public Double getFundingCount(Long id) {
        return this.loanMapper.getFundingCount(id);
    }
}
