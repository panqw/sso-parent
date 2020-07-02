package com.sso.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sso.common.entity.PageResult;
import com.sso.common.entity.StatusCode;
import com.sso.common.enums.DeleteEnum;
import com.sso.common.exception.GlobalExecption;
import com.sso.common.utils.BeanUtils;
import com.sso.goods.dao.SpecMapper;
import com.sso.goods.entity.Spec;
import com.sso.goods.entity.command.SpecCommand;
import com.sso.goods.entity.search.SpecSearch;
import com.sso.goods.service.SpecService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
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
public class SpecServiceImpl extends ServiceImpl<SpecMapper, Spec> implements SpecService {

    @Autowired
    private SpecMapper specMapper;

    @Override
    public Integer addSpec(SpecCommand command) {

        Spec spec = BeanUtils.copyProperties(command, Spec.class);
        spec.setCreateBy("PQW");
        spec.setUpdateBy("PQW");
        Date date = new Date();
        spec.setCreateTime(date);
        spec.setUpdateTime(date);
        return specMapper.insert(spec);
    }

    @Override
    public void updateSpec(@Valid SpecCommand command) {
        Spec spec = BeanUtils.copyProperties(command, Spec.class);
        spec.setUpdateBy("PQW");
        spec.setUpdateTime(new Date());
        specMapper.updateById(spec);
    }

    @Override
    public void deleteSpec(Integer id) {
        Spec spec = specMapper.selectById(id);
        Optional.ofNullable(spec).orElseThrow(() -> new GlobalExecption("不存在此规格"));
        spec.setUpdateBy("PQW");
        spec.setUpdateTime(new Date());
        spec.setIsDeleted(DeleteEnum.DELETE.getVal());
        specMapper.updateById(spec);
    }

    @Override
    public PageResult findSpecList(SpecSearch search) {
        PageHelper.startPage(search.getPage(),search.getRows());
        List<Spec> specList = specMapper.findSpecList(search);
        PageInfo<Spec> pageInfo = new PageInfo<>();

        PageResult<Spec> pageResult = new PageResult<>();
        pageResult.setCode(StatusCode.OK);
        pageResult.setData(specList);
        pageResult.setCount(pageInfo.getTotal());
        pageResult.setMessage("查询成功");
        return pageResult;
    }
}
