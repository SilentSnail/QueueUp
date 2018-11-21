package com.queue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.queue.entity.Directories;
import com.queue.entity.dto.DirectorDto;
import com.queue.entity.dto.DirectorListDto;
import com.queue.entity.vo.DirectorSearchVo;
import com.queue.mapper.DirectoriesMapper;
import com.queue.service.DirectoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusong
 * @since 2018-11-07
 */
@Service
public class DirectoriesServiceImpl extends ServiceImpl<DirectoriesMapper, Directories> implements DirectoriesService {

    @Autowired
    private DirectoriesMapper directoriesMapper;

    @Override
    public List<DirectorListDto> findBySearchVo(DirectorSearchVo search) {
        return this.directoriesMapper.findBySearchVo(search);
    }

    @Override
    public void delByCode(String code) {
        this.directoriesMapper.delByCode(code);
    }

    @Override
    public DirectorDto searchByCode(String code) {
        return this.directoriesMapper.searchByCode(code);
    }

    @Override
    public Integer updateDireByCode(Directories dire) {
        return this.directoriesMapper.updateDireByCode(dire);
    }
}
