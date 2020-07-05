package com.sso.common.enums;

/**
 * 是否删除枚举
 */
public enum  DeleteEnum {
    //保留
    NOT_DELETE(0),

    DELETE(1);

    private  final int i;

    DeleteEnum(int i) {
        this.i=i;
    }

    public Integer getVal() {
        return this.i;
    }

}
