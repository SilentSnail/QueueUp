package com.queue.mapper;

import com.queue.entity.Loan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.queue.entity.dto.LoanDto;
import com.queue.entity.dto.LoanListDto;
import com.queue.entity.vo.LoanSearchVo;
import org.apache.ibatis.annotations.Param;

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

    List<LoanListDto> searchByParam(LoanSearchVo search);

    Integer updateLoanByCode(Loan loan);

    LoanDto searchByCode(@Param("code") String code);

    Double getFundingCount(@Param("id") Long id);
}
