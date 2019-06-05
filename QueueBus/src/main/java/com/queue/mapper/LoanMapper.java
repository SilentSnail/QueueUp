package com.queue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.queue.entity.Loan;
import com.queue.entity.dto.LoanDto;
import com.queue.entity.dto.LoanListDto;
import com.queue.entity.vo.LoanSearchDetail;
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

    List<LoanDto> searchByCode(LoanSearchDetail search);

    Double getFundingCount(@Param("id") Long id);
}
