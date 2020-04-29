package com.puietel.service;

import com.alibaba.fastjson.JSONObject;
import com.puietel.entity.User;

import java.util.List;

/**
 * @Author Noway
 * @Date 2020/4/27 13:59
 * @Version 1.0
 * @Declare .....
 */
public interface UserService {

    User findUser(String username, String password);

    JSONObject findAllUser();
}
