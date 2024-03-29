package com.example.seckill.vo;

import com.example.seckill.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Return Detail object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailVo {
    private User user;

    private GoodsVo goodsVo;

    private int seckillStatus;

    private int remainSeconds;


}
