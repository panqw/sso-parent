package com.sso.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 广告模块
 * </p>
 *
 * @author wuyang
 * @since 2020-08-05
 */
@Component
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Ad implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 广告名称
     */
    private String name;

    /**
     * 广告位置
     */
    private String position;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 到期时间
     */
    private LocalDateTime endTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 图片地址
     */
    private String image;

    /**
     * URL
     */
    private String url;

    /**
     * 备注
     */
    private String remarks;


}
