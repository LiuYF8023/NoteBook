package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
//@TableName("tbl_user")
public class User {
//    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    @TableField(value = "pwd",select = false)
    private String password;
    private Integer age;
    private String tel;
    @TableField(exist = false)
    private Integer online;
//    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
