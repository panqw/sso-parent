package com.sso.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sso.goods.entity.Template;
import com.sso.goods.entity.command.TemplateCommand;

import javax.validation.Valid;

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


}
