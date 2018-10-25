package com.queue.service;

import com.queue.entity.Loan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.queue.entity.vo.LoanSearchVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
public interface LoanService extends IService<Loan> {

    List<Loan> searchByParam(LoanSearchVo search);
}
