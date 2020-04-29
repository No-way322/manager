package com.puietel.controller;

import com.alibaba.fastjson.JSONObject;
import com.puietel.annotation.JwtIgnore;
import com.puietel.common.response.Result;
import com.puietel.entity.User;
import com.puietel.model.Audience;
import com.puietel.service.UserService;
import com.puietel.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * @Author Noway
 * @Date 2020/4/27 15:07
 * @Version 1.0
 * @Declare .....
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Audience audience;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @JwtIgnore
    public JSONObject adminLogin(HttpServletResponse response, String username, String password) {
        User user = userService.findUser(username,password);
        JSONObject ret=new JSONObject();
        if(user == null){
            ret.put("result","0");
            ret.put("message","账号密码错误");
            ret.put("data","error");
            return ret;
        }else{
            // 这里模拟测试, 默认登录成功，返回用户ID和角色信息
            String userId = UUID.randomUUID().toString();
            String role = "admin";

            // 创建token
            String token = JwtTokenUtil.createJWT(userId, username, role, audience);
            log.info("### 登录成功, token={} ###", token);

            // 将token放在响应头
            response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);

            ret.put("token",token);
            ret.put("message","登录成功");
            ret.put("user",user);
            return ret;
        }
    }


    @GetMapping("/findAllUser")
    public JSONObject userList() {
        log.info("### 查询所有用户列表 ###");
        JSONObject ret = new JSONObject();
        ret = userService.findAllUser();
        return ret;
    }
}
