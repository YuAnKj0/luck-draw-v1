package com.yuan.luckinfrastrusture.convertor;
import com.yuan.luckdomain.user.UserName;
import com.yuan.luckdomain.user.PassWord;

import java.util.Objects;

import com.yuan.luckdomain.user.UserEntity;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.UserDB;

/**
 * @author Ykj
 * @date 2023/3/27/15:03
 * @apiNote
 */
public class UserConvertor {
    public static UserDB toUserDB(UserEntity entity) {
        UserDB userDB=new UserDB();
        userDB.setId(entity.getId());
        userDB.setUsername(entity.getUsername().getUsername());
        if (Objects.nonNull(entity.getPassword())){
            userDB.setPassword(entity.getPassword().getEncryptionPassWord().getPassword());
        }
        
        userDB.setName(entity.getName());
        userDB.setPhone(entity.getPhone());
        userDB.setCreateTime(entity.getCreateTime());
        userDB.setCreator("admin");
        userDB.setUpdateTime(entity.getUpdateTime());
        userDB.setUpdater("admin");
         
        
        return userDB;
    }
    
    public static UserEntity toEntity(UserDB userDB) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDB.getId());
        userEntity.setUsername(new UserName(userDB.getUsername()));
        userEntity.setPassword(new PassWord(new PassWord.EncryptionPassWord(userDB.getPassword())));
        userEntity.setName(userDB.getName());
        userEntity.setPhone(userDB.getPhone());
        userEntity.setCreateTime(userDB.getCreateTime());
        userEntity.setUpdateTime(userDB.getUpdateTime());
        
        return userEntity;
    }
}
