package com.yuan.base.config.exception;

import com.yuan.base.config.vo.FailInfo;

/**
 * @author Ykj
 * @date 2023/4/23/11:09
 * @apiNote
 */


public class LDCodeException extends RuntimeException {
    private Integer code;
    
    public Integer getCode() {
        return code;
    }
    
    public LDCodeException(){}
    
    public LDCodeException(Integer code,String message,Object ... args){
        super(String.format(message, args));
        this.code = code;
    }
    
    public LDCodeException(String message,Object ... args){
        super(String.format(message, args));
        this.code= FailInfo.DEFAULT_CODE;
    }
    
    public LDCodeException(String message,Throwable cause,Object ... args){
        super(String.format(message,args), cause);
        this.code= FailInfo.DEFAULT_CODE;
    }
    public LDCodeException(Throwable cause){super(cause);
        this.code= FailInfo.DEFAULT_CODE;}
    
}
