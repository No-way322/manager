package com.puietel.dao;

import com.puietel.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Noway
 * @Date 2020/4/27 13:59
 * @Version 1.0
 * @Declare .....
 */
@Component
public interface UserDao {

    /**
     * 登录验证
     */
    User findUser(@Param("username") String username,
                @Param("password") String password);

    List<User> findAllUser();
}
