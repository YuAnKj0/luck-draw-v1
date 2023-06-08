package com.yuan.luckapp.record.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckapp.assembler.RecordAssembler;
import com.yuan.luckclient.service.dto.data.RecordVO;
import com.yuan.luckclient.service.dto.query.RecordListByParamQuery;
import com.yuan.luckdomain.gateway.RecordGateway;
import com.yuan.luckdomain.record.RecordEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/5/26/11:48
 * @apiNote
 */

@Slf4j
@Component
@AllArgsConstructor
public class RecordListByParamQueryExe {
    private final RecordGateway recordGateway;
    
    public IPage<RecordVO> page(RecordListByParamQuery query) {
        IPage<RecordEntity> page = recordGateway.page(query);
        return page.convert(RecordAssembler::toRecordVO);
    }
}
