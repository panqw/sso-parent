package com.sso.goods.controller;

import com.sso.common.entity.PageResult;
import com.sso.common.entity.Result;
import com.sso.goods.entity.command.CommentCommand;
import com.sso.goods.entity.command.GoodsCommand;
import com.sso.goods.entity.search.GoodsSearch;
import com.sso.goods.entity.vo.CommentVo;
import com.sso.goods.service.SkuService;
import com.sso.goods.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    /**
     * 添加搜索栏历史
     * @param searchParam
     * @param userId
     */
    @PostMapping("/search")
    public void search(@RequestParam("searchParam") String searchParam,
                       @RequestParam("userId") String userId){
        spuService.search(searchParam,userId);
    }

    /**
     * 查询搜索栏历史
     * @param userId
     * @return
     */
    @PostMapping("/getSearch")
    public List<String> getSearch(@RequestParam("userId") String userId){
        return spuService.getSearch(userId);
    }


    /**
     * 添加商品评论
     */
    @PostMapping("/addComment")
    public void addComment(@RequestBody CommentCommand command){
        spuService.addComment(command);
    }

    /**
     * 查看商品评论
     */
    @PostMapping("/getComment")
    public List<CommentVo> getComment(@RequestBody CommentCommand command){
       return spuService.getComment(command);
    }
}
