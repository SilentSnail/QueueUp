package com.queue.service.impl;

import com.queue.entity.FileRecord;
import com.queue.mapper.FileRecordMapper;
import com.queue.service.FileRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusong
 * @since 2019-04-18
 */
@Service
public class FileRecordServiceImpl extends ServiceImpl<FileRecordMapper, FileRecord> implements FileRecordService {

    @Autowired
    private FileRecordMapper fileRecordMapper;

    @Override
    public Integer updateIouInfo(String[] images, String rel_code) {
        return this.fileRecordMapper.updateIouInfoById(images, rel_code);
    }
}
