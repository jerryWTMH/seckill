package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.Goods;
import com.example.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  Get the product list
 * </p>
 *
 * @author jerry
 */

public interface IGoodsService extends IService<Goods> {
    List<GoodsVo> findGoodsVo();
}
