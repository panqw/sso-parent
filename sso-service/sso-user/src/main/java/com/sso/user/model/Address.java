package com.sso.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author wuyang
 * @since 2020-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 省
     */
    private String provinceid;

    /**
     * 市
     */
    private String cityid;

    /**
     * 县/区
     */
    private String areaid;

    /**
     * 电话
     */
    private String phone;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 是否是默认 1默认 0否
     */
    private String isDefault;

    /**
     * 别名
     */
    private String alias;


}
