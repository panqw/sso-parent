package com.sso.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sso.common.entity.PageResult;
import com.sso.goods.entity.Template;
import com.sso.goods.entity.command.TemplateCommand;
import com.sso.goods.entity.search.TemplateSearch;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panqw
 * @since 2020-06-24
 */
public interface TemplateService extends IService<Template> {

    Integer addTemplate(TemplateCommand command);

    Integer updateTemplate(TemplateCommand command);

    Integer deleteTemplate(Integer id);

    PageResult findTemplateList(TemplateSearch search);
}
