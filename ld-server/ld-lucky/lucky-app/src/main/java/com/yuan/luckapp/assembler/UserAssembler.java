package com.yuan.luckapp.assembler;
import com.yuan.luckclient.service.dto.UserUpdateCmd;
import com.yuan.luckclient.service.dto.data.UserVO;
import com.yuan.luckdomain.user.UserName;
import java.time.LocalDateTime;
import com.yuan.luckdomain.user.PassWord;

import com.yuan.luckclient.service.dto.UserRegisterCmd;
import com.yuan.luckdomain.user.UserEntity;

/**
 * @author Ykj
 * @date 2023/3/27/15:15
 * @apiNote
 */
public class UserAssembler {
    public static UserEntity toAddEntity(UserRegisterCmd cmd) {
        UserEntity entity = new UserEntity();
        entity.setUsername(new UserName(cmd.getUsername()));
        entity.setPassword(new PassWord(new PassWord.EncryptionPassWord(PassWord.getEncryptionPassWord(cmd.getPassword()))));
        entity.setName(cmd.getName());
        entity.setPhone(cmd.getPhone());
        entity.setCreateTime(LocalDateTime.now());
        entity.setUpdateTime(LocalDateTime.now());
        return entity;
    }
    
    public static UserVO toUserVO(UserEntity entity) {
        UserVO userVO = new UserVO();
        userVO.setId(entity.getId());
        userVO.setUsername(entity.getUsername().getUsername());
        userVO.setName(entity.getName());
        userVO.setPhone(entity.getPhone());
        userVO.setCreateTime(entity.getCreateTime());
        userVO.setCreator(entity.getCreator());
        userVO.setUpdateTime(entity.getUpdateTime());
        return userVO;
    }
    
    public static UserEntity toUpdateEntity(UserUpdateCmd cmd) {
        UserEntity entity = new UserEntity();
        entity.setUsername(new UserName(cmd.getUsername()));
        entity.setPassword(new PassWord(new PassWord.EncryptionPassWord(PassWord.getEncryptionPassWord(cmd.getPassword()))));
        entity.setName(cmd.getName());
        entity.setPhone(cmd.getPhone());
        //entity.setCreateTime(LocalDateTime.now());
        entity.setUpdateTime(LocalDateTime.now());
        return entity;
    }
}
