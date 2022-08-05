package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.Order;
import com.example.seckill.pojo.User;
import com.example.seckill.vo.GoodsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jerry
 */
public interface IOrderService extends IService<Order> {
    /**
     * Seckill
     * @param user
     * @param goods
     * @return
     */
    Order seckill(User user, GoodsVo goods);
}
