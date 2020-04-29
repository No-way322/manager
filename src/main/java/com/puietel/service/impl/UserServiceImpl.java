package com.puietel.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.puietel.dao.UserDao;
import com.puietel.entity.User;
import com.puietel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Noway
 * @Date 2020/4/27 14:03
 * @Version 1.0
 * @Declare .....
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;



    @Override
    public User findUser(String username, String password) {
        User user = userDao.findUser(username,password);
        return user;
    }

    @Override
    public JSONObject findAllUser() {
        List<User> userList = userDao.findAllUser();
        JSONObject ret = new JSONObject();
        if(userList != null){
            ret.put("userList",userList);
            ret.put("message","查询成功");
        }else{
            ret.put("message","查询失败");
        }
        return ret;
    }
}
