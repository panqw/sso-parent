package com.sso.common.enums;

/**
 * 商品SPU状态枚举
 * @author panqw
 * @date 2020/7/2 17:19
 */
public enum GoodsAuditStatus {

        WAIT_AUDIT("0","待审核"),

        AUDITED("2","已审核"),

        REJECTED("4","已驳回");

    private String status;

    private String description;

    GoodsAuditStatus(String status, String description) {
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
