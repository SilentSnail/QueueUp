package com.queue.service.impl;

import com.queue.entity.Pay;
import com.queue.mapper.PayMapper;
import com.queue.service.PayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusong
 * @since 2019-06-27
 */
@Service
public class PayServiceImpl extends ServiceImpl<PayMapper, Pay> implements PayService {

    @Autowired
    private PayMapper payMapper;
}
