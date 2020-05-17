package com.queue.service;

import com.queue.entity.FileRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liusong
 * @since 2019-04-18
 */
public interface FileRecordService extends IService<FileRecord> {

    Integer updateIouInfo(String[] images, String rel_code);
}
