package com.queue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.queue.entity.Directories;
import com.queue.entity.dto.DirectorDto;
import com.queue.entity.dto.DirectorListDto;
import com.queue.entity.vo.DirectorSearchVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liusong
 * @since 2018-11-07
 */
public interface DirectoriesService extends IService<Directories> {

    /**
     * 依据条件查询用户信息
     * @param search
     * @return
     */
    List<DirectorListDto> findBySearchVo(DirectorSearchVo search);

    /**
     * 依据Code删除联系人
     * @param code
     */
    void delByCode(String code);

    /**
     * 依据Code查询
     * @param code
     * @return
     */
    DirectorDto searchByCode(String code);

    /**
     * 更新联系人信息
     * @param dire
     * @return
     */
    Integer updateDireByCode(Directories dire);
}
