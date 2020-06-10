package com.sso.goods.controller;


import com.sso.common.command.BaseCommand;
import com.sso.common.entity.Result;
import com.sso.common.exception.GlobalExecption;
import com.sso.goods.entity.Brand;
import com.sso.goods.entity.command.BrandCommand;
import com.sso.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author panqw
 * @since 2020-06-01
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;


    @PostMapping("/findBrandList")
    public Result findBrandList( BrandCommand command){

        List<Brand> brandList = brandService.findBrandList(command);
        return new Result(true,200,"success",brandList);
    }

    @PostMapping("/findById")
    public Result findById(@RequestBody BrandCommand command){
        Brand brand = brandService.findById(command.getId());

        return new Result(true,200,"success",brand);
    }

    @PostMapping("/createBrand")
    public Result createBrand(@RequestBody  @Valid  BrandCommand command){

        Integer num = brandService.createBrand(command);
        if (num<=0){
            throw new GlobalExecption("插入失败");
        }

        return new Result(true,200,"success");
    }



}
