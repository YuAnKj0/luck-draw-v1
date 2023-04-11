package com.yuan.luckclient.service.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

/**
 * @author Ykj
 * @date 2023/4/10/16:31
 * @apiNote
 */
@Data
public class PrizeListByParamQuery extends PageQuery {
    
    private Long id;
    
    private String prizeName;
    
    private Integer type;
}
