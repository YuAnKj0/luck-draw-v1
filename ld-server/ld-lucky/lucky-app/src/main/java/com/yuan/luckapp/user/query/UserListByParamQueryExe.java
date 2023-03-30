package com.yuan.luckapp.user.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckapp.assembler.UserAssembler;
import com.yuan.luckclient.service.dto.data.UserVO;
import com.yuan.luckclient.service.dto.query.UserListByParamQuery;
import com.yuan.luckdomain.gateway.UserGateway;
import com.yuan.luckdomain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/3/30/10:42
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserListByParamQueryExe {
    private final UserGateway userGateway;
    
    public IPage<UserVO> execute(UserListByParamQuery query){
        IPage<UserEntity> page = userGateway.findByParam(query);
        return page.convert(UserAssembler::toUserVO);
        
    }   
   
}
