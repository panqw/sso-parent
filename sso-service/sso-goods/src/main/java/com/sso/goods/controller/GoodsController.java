package com.sso.goods.controller;

import com.sso.common.entity.PageResult;
import com.sso.common.entity.Result;
import com.sso.goods.entity.command.GoodsCommand;
import com.sso.goods.entity.search.GoodsSearch;
import com.sso.goods.service.SkuService;
import com.sso.goods.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 商品控制器
 * @author panqw
 * @date 2020/7/2 14:24
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private SpuService spuService;

    /**
     * 添加商品
     * @param command
     * @return
     */

    @RequestMapping("/addGoods")
    public Result addGoods(@RequestBody @Valid GoodsCommand command){

        return spuService.addGoods(command);
    }

    @RequestMapping("/findGoodsList")
    public PageResult findGoodsList(@RequestBody GoodsSearch search){

       return spuService.findGoodsList(search);
    }
}
