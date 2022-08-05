package com.example.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author jerry
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Product ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * Product Name
     */
    private String goodsName;

    /**
     * Product Title
     */
    private String goodsTitle;

    /**
     * Product Image
     */
    private String goodsImg;

    /**
     * Product Description
     */
    private String goodsDetail;

    /**
     * Product Price
     */
    private BigDecimal goodsPrice;

    /**
     * Product in stock,-1 represents no limitation
     */
    private Integer goodsStock;


}
