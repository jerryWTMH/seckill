package com.example.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckill.pojo.Goods;
import com.example.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jerry
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * Get Product list
     * @return
     */
    List<GoodsVo> findGoodsVo();
}
