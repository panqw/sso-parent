package com.sso.goods.service;

import com.sso.common.entity.PageResult;
import com.sso.goods.entity.Spec;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sso.goods.entity.command.SpecCommand;
import com.sso.goods.entity.search.SpecSearch;

import javax.validation.Valid;
import java.util.List;

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

    void updateSpec(@Valid SpecCommand command);

    void deleteSpec(Integer id);

    PageResult findSpecList(SpecSearch search);
}
