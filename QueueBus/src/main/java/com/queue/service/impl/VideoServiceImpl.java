package com.queue.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.queue.entity.Video;
import com.queue.mapper.VideoMapper;
import com.queue.service.VideoService;
import org.springframework.stereotype.Service;

/**
 * Created by liusong on 2018/10/12.
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}
