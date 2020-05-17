package com.queue.mapper;

import com.queue.entity.FileRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liusong
 * @since 2019-04-18
 */
public interface FileRecordMapper extends BaseMapper<FileRecord> {

    Integer updateIouInfoById(@Param("images") String[] images, @Param("rel_code") String rel_code);
}
