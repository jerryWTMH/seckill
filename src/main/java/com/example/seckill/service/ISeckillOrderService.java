package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.SeckillOrder;
import com.example.seckill.pojo.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jerry
 */
public interface ISeckillOrderService extends IService<SeckillOrder> {
    /**
     * Get seckill result
     * @param user
     * @param goodsId
     * @return orderId: sucess; -1: fail; 0: queueing
     */
    Long getResult(User user, Long goodsId);
}
