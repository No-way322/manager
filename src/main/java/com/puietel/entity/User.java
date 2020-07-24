package com.puietel.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Noway
 * @Date 2020/4/27 13:59
 * @Version 1.0
 * @Declare .....
 */

@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String job;
    private String sex;

}
