package com.queue.service;

import com.queue.entity.Authority;
import com.baomidou.mybatisplus.extension.service.IService;
import com.queue.entity.dto.AuthorityInfoDto;
import com.queue.entity.vo.AuthoritySearchVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liusong
 * @since 2019-05-11
 */
public interface AuthorityService extends IService<Authority> {

    List<AuthorityInfoDto> searchAuthorityList(AuthoritySearchVo search);
}
