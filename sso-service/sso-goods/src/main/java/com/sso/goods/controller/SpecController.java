package com.sso.goods.controller;


import com.sso.common.entity.Result;
import com.sso.common.entity.StatusCode;
import com.sso.common.exception.GlobalExecption;
import com.sso.goods.entity.command.SpecCommand;
import com.sso.goods.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

        Integer num = specService.addSpec(command);
        if (num<=0){
            throw new GlobalExecption("添加失败");
        }
        return new Result(true, StatusCode.OK,"添加成功");
    }
}
