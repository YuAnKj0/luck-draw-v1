package com.yuan.luckapp.award.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.luckapp.assembler.AwardAssembler;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckclient.service.dto.query.AwardListByParamQuery;
import com.yuan.luckdomain.award.AwardEntity;
import com.yuan.luckdomain.gateway.AwardGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/4/11/17:38
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class AwardListByParamQueryExe {
    private final AwardGateway gateway;
    public IPage<AwardVO> execute(AwardListByParamQuery query) {
        IPage<AwardEntity> queryPage = gateway.page(query);
        return queryPage.convert(AwardAssembler::toAwardVO);
    }
}
