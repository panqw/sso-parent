package com.sso.goods.controller;


import com.sso.common.entity.Result;
import com.sso.common.entity.StatusCode;
import com.sso.common.exception.GlobalExecption;
import com.sso.goods.entity.Template;
import com.sso.goods.entity.command.TemplateCommand;
import com.sso.goods.service.TemplateService;
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
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    /**
     * 添加模板
     *
     */
    @PostMapping("/addTemplate")
    public Result addTemplate(@RequestBody @Valid TemplateCommand command){
        if (null==command.getId()) {
            templateService.addTemplate(command);
        }else {
            templateService.updateTemplate(command);
        }

        return new Result(true, StatusCode.OK,"添加成功");
    }

    /**
     * 删除模板
     *
     */
    @GetMapping("/deleteTemplate")
    public Result deleteTemplate(@RequestParam("id") Integer id){
        Integer num = templateService.deleteTemplate(id);
        if (num<=0){
            throw new GlobalExecption("删除失败");
        }
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
