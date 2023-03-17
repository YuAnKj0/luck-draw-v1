package com.yuan.config.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Ykj
 * @date 2023/3/16/17:13
 * @apiNote

 */
@ToString
@Builder
@Getter
public class FailInfo extends ResultInfo {
    
    protected static final Integer DEFAULT_CODE=50000;
    protected static final String DEFAULT_MESSAGE = "操作失败";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String exception;
    
    protected FailInfo(String exception){
        super(false,DEFAULT_CODE,DEFAULT_MESSAGE);
        this.exception = exception;
    }
    
    /**
     * 
     * @param code
     * @param exception
     */
    public FailInfo(Integer code,String exception){
        super(false,code,DEFAULT_MESSAGE);
        this.exception=exception;
    }
    
}
