package com.sso.goods.controller;



import com.sso.common.entity.PageResult;
import com.sso.common.entity.Result;
import com.sso.common.entity.StatusCode;
import com.sso.goods.entity.Brand;
import com.sso.goods.entity.command.BrandCommand;
import com.sso.goods.entity.vo.BrandVo;
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
    public PageResult<BrandVo> findBrandList(@RequestBody BrandCommand command) {

        return brandService.findBrandList(command);
    }

    @PostMapping("/findById")
    public Result findById(@RequestBody BrandCommand command){
        Brand brand = brandService.findById(command.getId());

        return new Result(true,StatusCode.OK,"success",brand);
    }

    @PostMapping("/addOrUpdateBrand")
    public Result addOrUpdateBrand(@RequestBody@Valid BrandCommand command){
        if (null==command.getId()) {
            brandService.addBrand(command);
        }else {
            brandService.updateBrand(command);
        }

        return new Result(true,StatusCode.OK,"success");
    }



}
