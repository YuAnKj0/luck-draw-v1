package com.yuan.luckclient.service.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

@Data
public class RecordUpdateStatusCmd extends Command {

    /**
     *
     */
    private Long id;

    /**
     * 状态（0，1，2，3）
     */
    private Integer state;
}
