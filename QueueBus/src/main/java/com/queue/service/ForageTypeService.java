package com.queue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.queue.entity.ForageType;
import com.queue.entity.dto.ForageNameDto;
import com.queue.entity.dto.ForageTypeDto;
import com.queue.entity.vo.ForageTypeSearchVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liusong
 * @since 2019-06-18
 */
public interface ForageTypeService extends IService<ForageType> {

    List<ForageTypeDto> findByParam(ForageTypeSearchVo param);

    List<ForageNameDto> findParnetByCode(String parentCode);
}
