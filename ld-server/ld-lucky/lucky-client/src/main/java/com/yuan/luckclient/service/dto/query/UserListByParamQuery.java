package com.yuan.luckclient.service.dto.query;

import com.alibaba.cola.dto.PageQuery;
import com.alibaba.cola.dto.Query;
import lombok.Data;

/**
 * @author Ykj
 * @date 2023/3/20/19:08
 * @apiNote
 */
@Data
public class UserListByParamQuery extends PageQuery {
    private Long id;
    
    private String name;
    
    private String phone;
}
