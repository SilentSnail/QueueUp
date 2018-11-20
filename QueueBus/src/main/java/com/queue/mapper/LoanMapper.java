package com.queue.mapper;

import com.queue.entity.Loan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.queue.entity.dto.LoanDto;
import com.queue.entity.vo.LoanSearchVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liusong
 * @since 2018-11-20
 */
public interface LoanMapper extends BaseMapper<Loan> {

    List<LoanDto> searchByParam(LoanSearchVo search);
}
