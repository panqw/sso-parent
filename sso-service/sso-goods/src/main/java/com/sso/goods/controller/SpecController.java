package com.sso.goods.controller;


import com.sso.common.entity.PageResult;
import com.sso.common.entity.Result;
import com.sso.common.entity.StatusCode;
import com.sso.common.exception.GlobalExecption;
import com.sso.goods.entity.command.SpecCommand;
import com.sso.goods.entity.search.SpecSearch;
import com.sso.goods.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author panqw
 * @since 2020-06-24
 */
@RestController
@RequestMapping("/spec")
public class SpecController {

    @Autowired
    private SpecService specService;

    @PostMapping("/addSpec")
    public Result addSpec(@RequestBody @Valid SpecCommand command){
        if(null==command.getId()){
            specService.addSpec(command);
        }else {
            specService.updateSpec(command);
        }

        return new Result(true, StatusCode.OK,"添加成功");
    }

    @PostMapping("/deleteSpec")
    public Result deleteSpec(@RequestParam("id") Integer id){
        specService.deleteSpec(id);

        return new Result(true,StatusCode.OK,"删除成功");
    }

    @PostMapping("/findSpecList")
    public PageResult findSpecList(@RequestBody SpecSearch search){
        if (null==search.getTemplateId()){
            throw new GlobalExecption("模板id不能为空");
        }
        return specService.findSpecList(search);
    }
}
