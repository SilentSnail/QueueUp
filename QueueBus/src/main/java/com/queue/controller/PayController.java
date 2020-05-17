package com.queue.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.queue.entity.FileRecord;
import com.queue.entity.Pay;
import com.queue.service.FileRecordService;
import com.queue.service.ForageTypeService;
import com.queue.service.PayService;
import com.queue.utils.R;
import com.queue.utils.SecurityEncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liusong
 * @since 2019-06-27
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayService payService;
    @Autowired
    private ForageTypeService forageTypeService;
    @Autowired
    private FileRecordService fileRecord;

    /**
     * 获取选项
     * @param parentCode
     * @return
     */
    @RequestMapping("/getItem")
    public R getSelectItem(String parentCode){
        return R.ok(this.forageTypeService.findParnetByCode(parentCode));
    }

    /**
     * 保存支出信息
     * @param pay 支出信息
     * @param files 发票文件ID
     * @return
     */
    @RequestMapping("/addInfo")
    public R save(Pay pay, String files){
        pay.setPayCode(SecurityEncryptUtils.getUUID());
        if(!StringUtils.hasText(pay.getOrderNo())){
            pay.setOrderNo(SecurityEncryptUtils.getNumberNo());
        }
        this.payService.saveOrUpdate(pay);
        if(StringUtils.hasText(files)){//如果存在发票
            String[] fileIds = files.split(",");
            for (String code : fileIds) {
                if(StringUtils.hasText(code)){
                    FileRecord file = this.fileRecord.getOne(new QueryWrapper<FileRecord>().eq("code", code));
                    file.setRelationCode(pay.getPayCode());
                    this.fileRecord.updateById(file);
                }
            }
        }
        return R.ok();
    }
}

