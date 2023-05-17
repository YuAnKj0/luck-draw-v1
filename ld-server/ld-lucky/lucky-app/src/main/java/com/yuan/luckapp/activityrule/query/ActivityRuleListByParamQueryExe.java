package com.yuan.luckapp.activityrule.query;

import cn.hutool.core.collection.CollectionUtil;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.luckapp.assembler.ActivityRuleAssembler;
import com.yuan.luckclient.service.dto.data.ActivityRuleVO;
import com.yuan.luckclient.service.dto.query.ActivityRuleListByParamQuery;
import com.yuan.luckdomain.activityrule.ActivityRuleEntity;
import com.yuan.luckdomain.gateway.ActivityRuleGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Component
@AllArgsConstructor
public class ActivityRuleListByParamQueryExe {

    private final ActivityRuleGateway activityRuleGateway;

    public List<ActivityRuleVO> execute(ActivityRuleListByParamQuery query) {
        List<ActivityRuleEntity> list = activityRuleGateway.list(query);

        if (CollectionUtil.isEmpty(list)) {
            return new ArrayList<>();
        }

        return new Page<ActivityRuleEntity>()
                .setRecords(list)
                .convert(ActivityRuleAssembler::toActivityRuleVO)
                .getRecords();
    }
}
