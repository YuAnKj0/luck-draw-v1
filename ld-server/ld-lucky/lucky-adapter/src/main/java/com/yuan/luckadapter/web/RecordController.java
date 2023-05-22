package com.yuan.luckadapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.base.common.annotation.ResponseResult;
import com.yuan.base.config.utils.SecurityUtil;

import com.yuan.luckclient.service.api.IRecordService;
import com.yuan.luckclient.service.dto.RecordUpdateStatusCmd;
import com.yuan.luckclient.service.dto.data.RecordVO;
import com.yuan.luckclient.service.dto.query.RecordListByParamQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/v1/record")
public class RecordController {

    private final IRecordService recordService;

    @PostMapping("/page")
    public IPage<RecordVO> page(@RequestBody RecordListByParamQuery query) {
        query.setUserId(SecurityUtil.getUserId());
        return recordService.page(query);
    }
    
    @GetMapping("/prizeType")
    public Integer prizeType(@RequestParam("recordId") Long recordId) {
        return recordService.prizeType(recordId);
    }
    
    @GetMapping("/updateStatusTo4")
    public Boolean updateStatusTo4(RecordUpdateStatusCmd cmd) {
        cmd.setState(4);
        return recordService.update(cmd);
    }
    
    
    @GetMapping("/exchangeMoney")
    public Boolean exchangeMoney(@RequestParam("recordId") Long recordId) {
        return recordService.exchangeMoney(recordId);
    }

}