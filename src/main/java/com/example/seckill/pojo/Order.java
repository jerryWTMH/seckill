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
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Order ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * User ID
     */
    private Long userId;

    /**
     * Product ID
     */
    private Long goodsId;

    /**
     * Delivery Address ID
     */
    private Long deliveryAddrId;

    /**
     * Product Name
     */
    private String goodsName;

    /**
     * Product Count
     */
    private Integer goodsCount;

    /**
     * Product Price
     */
    private BigDecimal goodsPrice;

    /**
     * 1 PC, 2 Android, 3 ios
     */
    private Integer orderChannel;

    /**
     * Order Status，0 Has not pay，1 Already pay，2 Already Delivery，3 Already Receive，4 Already Refund，5 Already Finished
     */
    private Integer status;

    /**
     * Order Create Time
     */
    private Date createDate;

    /**
     * Pay Time
     */
    private Date payDate;


}
