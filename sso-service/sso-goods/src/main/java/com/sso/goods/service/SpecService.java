package com.sso.goods.service;

import com.sso.goods.entity.Spec;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sso.goods.entity.command.SpecCommand;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panqw
 * @since 2020-06-24
 */
public interface SpecService extends IService<Spec> {

    Integer addSpec(SpecCommand command);
}
