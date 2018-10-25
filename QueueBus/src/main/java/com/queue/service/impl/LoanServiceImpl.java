package com.queue.service.impl;

import com.queue.entity.Loan;
import com.queue.entity.vo.LoanSearchVo;
import com.queue.mapper.LoanMapper;
import com.queue.service.LoanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
@Service
public class LoanServiceImpl extends ServiceImpl<LoanMapper, Loan> implements LoanService {

    @Autowired
    private LoanMapper loanMapper;

    public List<Loan> searchByParam(LoanSearchVo search) {
        return this.loanMapper.searchByParam(search);
    }
}
