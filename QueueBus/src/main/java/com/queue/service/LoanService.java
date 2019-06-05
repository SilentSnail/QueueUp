package com.queue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.queue.entity.Loan;
import com.queue.entity.dto.LoanDto;
import com.queue.entity.dto.LoanListDto;
import com.queue.entity.vo.LoanSearchDetail;
import com.queue.entity.vo.LoanSearchVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liusong
 * @since 2018-11-20
 */
public interface LoanService extends IService<Loan> {

    List<LoanListDto> searchByParam(LoanSearchVo search);

    boolean updateLoanByCode(Loan loan);

    List<LoanDto> searchByCode(LoanSearchDetail search);

    Double getFundingCount(Long id);
}
