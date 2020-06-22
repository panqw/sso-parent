package com.sso.goods.controller;


import com.sso.common.entity.Result;
import com.sso.common.entity.StatusCode;
import com.sso.goods.entity.command.CategoryCommand;
import com.sso.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 商品类目 前端控制器
 * </p>
 *
 * @author panqw
 * @since 2020-06-01
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addOrUpdateCategory")
    public Result addOrUpdateCategory(@RequestBody @Valid CategoryCommand command){
        if (null == command.getId()){
            categoryService.addCategory(command);
        }else {
            categoryService.updateCategory(command);
        }
        return new Result(true, StatusCode.OK,"新增商品分类成功");
    }

}
