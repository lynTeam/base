package com.xingkong.lyn.model.shop;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lyn on 2017/6/5.
 */
@Entity
@Data
@Table(name = "shop_order_sku")
public class OrderSku implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private Long orderId;

    private Long skuId;

    private String skuName;

    private int skuQuantity;

    private double skuPrice;

    private String skuImage;

    private Date createTime;
}
