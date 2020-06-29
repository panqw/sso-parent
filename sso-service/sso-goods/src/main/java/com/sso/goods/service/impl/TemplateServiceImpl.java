package com.sso.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sso.common.entity.PageResult;
import com.sso.common.entity.StatusCode;
import com.sso.common.exception.GlobalExecption;
import com.sso.common.utils.BeanUtils;
import com.sso.goods.dao.TemplateMapper;
import com.sso.goods.entity.Template;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sso.goods.entity.command.TemplateCommand;
import com.sso.goods.entity.search.TemplateSearch;
import com.sso.goods.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panqw
 * @since 2020-06-24
 */
@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateMapper, Template> implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public Integer addTemplate(TemplateCommand command) {

        Template template = BeanUtils.copyProperties(command, Template.class);
        template.setCreateBy("PQW");
        template.setUpdateBy("PQW");
        Date date = new Date();
        template.setCreateTime(date);
        template.setUpdateTime(date);
        return templateMapper.insert(template);
    }

    @Override
    public Integer updateTemplate(TemplateCommand command) {
        Template template = BeanUtils.copyProperties(command, Template.class);
        template.setUpdateBy("PQW");
        template.setUpdateTime(new Date());
        return templateMapper.updateById(template);
    }

    @Override
    public Integer deleteTemplate(Integer id) {
        Template template = templateMapper.selectById(id);
        Optional.ofNullable(template).orElseThrow(()->new GlobalExecption("模板不存在"));
        template.setIsDeleted(1);
        template.setUpdateBy("PQW");
        template.setUpdateTime(new Date());
        return templateMapper.updateById(template);
    }

    @Override
    public PageResult findTemplateList(TemplateSearch search) {
        PageHelper.startPage(search.getPage(),search.getRows());
        List<Template> templateList = templateMapper.findTemplateList(search);
        PageInfo<Template> pageInfo = new PageInfo<>();

        PageResult<Template> pageResult = new PageResult<>();
        pageResult.setCount(pageInfo.getTotal());
        pageResult.setData(templateList);
        pageResult.setCode(StatusCode.OK);
        return pageResult;
    }
}
