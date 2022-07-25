package com.example.seckill.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author jerry
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * User ID, cellphone
     */
    private Long id;

    private String nickname;

    /**
     * MD5(MD5(pass + fixed salt) + salt)
     */
    private String password;

    private String salt;

    /**
     * Avatar
     */
    private String head;

    /**
     * Register time
     */
    private Date registerDate;

    /**
     * Time of Last sign-in
     */
    private Date lastLoginDate;

    /**
     * sign-in times
     */
    private Integer loginCount;


}
