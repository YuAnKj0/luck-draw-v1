package com.yuan.luckadapter.web;


import com.yuan.base.common.annotation.ResponseResult;
import com.yuan.base.config.utils.SecurityUtil;
import com.yuan.luckclient.service.api.IUserService;
import com.yuan.luckclient.service.dto.UserRegisterCmd;
import com.yuan.luckclient.service.dto.UserUpdateCmd;
import com.yuan.luckclient.service.dto.data.UserVO;
import com.yuan.luckclient.service.dto.query.UserLoginQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;




/**
 * @author Ykj
 * @date 2023/3/27/14:22
 * @apiNote
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/v1/user")
public class UserController {
    private IUserService userService;
    
    @PostMapping("/register")
    public UserVO register(@Validated @RequestBody UserRegisterCmd cmd){
        return userService.register(cmd);
        
    }
    
    @PostMapping("/login")
    public String login(@Validated @RequestBody UserLoginQuery query){
        return userService.login(query);
        
    }
    
    @GetMapping("/me")
    public UserVO me(){
        return userService.one(SecurityUtil.getUserId());
    }
    @GetMapping("/one")
    public UserVO one(@RequestParam("id") Long id){
        return userService.one(id);
    }
    @PostMapping("/update")
    public UserVO update(@Validated @RequestBody UserUpdateCmd cmd){
        return userService.update(cmd);
        
    }
}
