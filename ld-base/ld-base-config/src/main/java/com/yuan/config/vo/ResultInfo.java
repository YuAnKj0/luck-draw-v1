package com.yuan.config.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author Ykj
 * @date 2023/3/16/17:08
 * @apiNote
 */
@Getter
public class ResultInfo implements Serializable {
    
    private boolean result;
    private Integer code;
    /**
     * message=null时，不序列化出去
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    protected ResultInfo(Boolean result,Integer code,String message) {
        this.result=result;
        this.code=code;
        this.message=message;
    }
    
}
