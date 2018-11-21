package com.queue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.queue.entity.Directories;
import com.queue.entity.dto.DirectorDto;
import com.queue.entity.dto.DirectorListDto;
import com.queue.entity.vo.DirectorSearchVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liusong
 * @since 2018-11-07
 */
public interface DirectoriesMapper extends BaseMapper<Directories> {

    List<DirectorListDto> findBySearchVo(DirectorSearchVo search);

    void delByCode(@Param("code") String code);

    DirectorDto searchByCode(String code);

    Integer updateDireByCode(Directories dire);
}
