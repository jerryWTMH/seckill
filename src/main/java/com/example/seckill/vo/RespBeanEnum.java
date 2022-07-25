package com.example.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * 公共返回对象枚举
 *
 * @author: LC
 * @date 2022/3/2 1:44 下午
 * @ClassName: RespBean
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {

    //通用
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "服务端异常");
    private final Integer code;
    private final String message;

}
