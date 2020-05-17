package com.queue.mapper;

import com.queue.entity.ForageType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.queue.entity.dto.ForageNameDto;
import com.queue.entity.dto.ForageTypeDto;
import com.queue.entity.vo.ForageTypeSearchVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liusong
 * @since 2019-06-18
 */
public interface ForageTypeMapper extends BaseMapper<ForageType> {

    List<ForageTypeDto> findByParam(ForageTypeSearchVo param);

    List<ForageNameDto> findParnetByCode(String parentCode);
}
