package com.queue.service.impl;

import com.queue.entity.Authority;
import com.queue.entity.dto.AuthorityInfoDto;
import com.queue.entity.vo.AuthoritySearchVo;
import com.queue.mapper.AuthorityMapper;
import com.queue.service.AuthorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusong
 * @since 2019-05-11
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public List<AuthorityInfoDto> searchAuthorityList(AuthoritySearchVo search) {
        return this.authorityMapper.searchAuthorityList(search);
    }
}
