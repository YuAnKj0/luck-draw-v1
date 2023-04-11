package com.yuan.luckdomain.rule;

import com.alibaba.cola.domain.Entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName ldb_rule
 */
@Entity
@Data
public class RuleEntity implements Serializable {

    private Long id;

    /**
     * 
     */
    private String ruleName;

    /**
     * 
     */
    private MinNumber maxJoinNumber;

    /**
     * 
     */
    private MinNumber maxWiningNumber;


    private LocalDateTime createTime;

    /**
     * 
     */
    private String creator;


    private LocalDateTime updateTime;

    /**
     * 
     */
    private String updater;

}