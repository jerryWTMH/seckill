package com.example.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("t_seckill_goods")
public class SeckillGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Seckill Product ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * Product ID
     */
    private Long goodsId;

    /**
     * Seckill Price
     */
    private BigDecimal seckillPrice;

    /**
     * The Number in stock
     */
    private Integer stockCount;

    /**
     * Seckill Start Time
     */
    private Date startDate;

    /**
     * Seckill End Time
     */
    private Date endDate;


}
