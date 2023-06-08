package com.yuan.luckdomain.record;

import com.alibaba.cola.domain.Entity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName ldb_record
 */
@Entity
@Data
public class RecordEntity implements Serializable {
    /**
     * 
     */

    private Long id;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long activityId;

    /**
     * 
     */
    private Long awardId;

    /**
     * 是否中奖：（0,1）默认非中奖0
     */
    private Integer isWining;

    /**
     * 状态：0,1,2,3
     */
    private RecordStatus state;


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