package com.sso.common.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

//用户秒杀排队
@Data
public class SeckillStatus {
    //秒杀用户
    private String username;

    private Date createTime;
    //秒杀状态 1：排队中，2：秒杀等待支付，3：支付超时，4：秒杀失败，5：支付完成
    private Integer status;

    private Long goodsId;

    private BigDecimal goodsMoney;

    private Long orderId;

    private String time;
}
