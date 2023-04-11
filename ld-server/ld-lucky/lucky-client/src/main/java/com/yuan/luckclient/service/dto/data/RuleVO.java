package com.yuan.luckclient.service.dto.data;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class RuleVO implements Serializable {

    private Long id;

    /**
     * 
     */
    private String ruleName;

    /**
     * 
     */
    private Integer maxJoinNumber;

    /**
     * 
     */
    private Integer maxWiningNumber;

    /**
     * 
     */

    private LocalDateTime createTime;

    /**
     * 
     */
    private String creator;

    /**
     * 
     */

    private LocalDateTime updateTime;

    /**
     * 
     */
    private String updater;
    
}