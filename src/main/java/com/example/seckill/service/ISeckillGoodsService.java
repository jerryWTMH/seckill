package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.SeckillGoods;
import com.example.seckill.pojo.SeckillOrder;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jerry
 */
public interface ISeckillGoodsService extends IService<SeckillGoods> {

    void save(SeckillOrder seckillOrder);
}
