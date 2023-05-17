package com.yuan.luckclient.service.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

import java.util.List;

/**
 * @author Ykj
 * @date 2023/4/11/11:19
 * @apiNote
 */
@Data
public class RuleListByParamQuery extends PageQuery {
   
   private Long id;
   private List<Long> ids;
   
   private String ruleName;
   
}
