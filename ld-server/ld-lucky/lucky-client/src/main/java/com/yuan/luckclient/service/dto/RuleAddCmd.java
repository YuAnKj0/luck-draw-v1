package com.yuan.luckclient.service.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Ykj
 * @date 2023/4/11/11:18
 * @apiNote
 */
@Data
public class RuleAddCmd extends Command {
    
 
    /**
     *
     */
    @NotNull(message = "规则名称不为空")
    private String ruleName;
    
    /**
     *
     */
    @NotNull(message = "最大参与次数不为空")
    private Integer maxJoinNumber;
    
    /**
     *
     */
    @NotNull(message = "最大获奖次数不为空")
    private Integer maxWiningNumber;
    
}
