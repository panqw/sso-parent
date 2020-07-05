package com.sso.common.enums;

/**
 * 商品SKU枚举
 * @author panqw
 * @date 2020/7/2 17:22
 */
public enum GoodsOnlineStatus {

    OFFONLINE("0","已下线"),

    ONLINE("2","已上线");

    private String status;

    private String description;

    GoodsOnlineStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
