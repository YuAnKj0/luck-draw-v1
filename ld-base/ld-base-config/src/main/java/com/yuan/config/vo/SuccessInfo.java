package com.yuan.config.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Ykj
 * @date 2023/3/16/17:13
 * @apiNote

 */
@ToString
@Builder
@Getter
public class SuccessInfo extends ResultInfo {
    
    protected static final Integer DEFAULT_CODE=20000;
    protected static final String DEFAULT_MESSAGE = "操作成功";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected Object data;
    
    protected SuccessInfo(Object data){
        super(true,DEFAULT_CODE,DEFAULT_MESSAGE);
        this.data=data;
    }
}
