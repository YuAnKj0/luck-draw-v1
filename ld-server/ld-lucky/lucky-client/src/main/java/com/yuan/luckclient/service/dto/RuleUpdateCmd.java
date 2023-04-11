package com.yuan.luckclient.service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Ykj
 * @date 2023/4/11/11:19
 * @apiNote
 */
@Data
public class RuleUpdateCmd {
    @NotNull(message = "规则id不为空")
    private Long id;
    
    @NotNull(message = "规则名称不为空")
    private String ruleName;
    
    /**
     *
     */
    @NotNull(message = "参与次数不为空")
    private Integer maxJoinNumber;
    
    /**
     *
     */
    @NotNull(message = "获奖次数不为空")
    private Integer maxWiningNumber;
}
