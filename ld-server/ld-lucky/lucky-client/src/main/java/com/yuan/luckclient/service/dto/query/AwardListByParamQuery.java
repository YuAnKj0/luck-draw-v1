package com.yuan.luckclient.service.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

/**
 * @author Ykj
 * @date 2023/4/11/16:11
 * @apiNote
 */
@Data
public class AwardListByParamQuery extends PageQuery {
    private Long id;
    private Long activityId;
    private String activityName;
    private String awardName;
}
