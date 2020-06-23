package com.sso.goods.controller;


import com.sso.common.entity.PageResult;
import com.sso.common.entity.Result;
import com.sso.common.entity.StatusCode;
import com.sso.common.exception.GlobalExecption;
import com.sso.goods.entity.Category;
import com.sso.goods.entity.command.CategoryCommand;
import com.sso.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    /**
     * 新增或修改商品分类
     * @param command
     * @return
     */
    @PostMapping("/addOrUpdateCategory")
    public Result addOrUpdateCategory(@RequestBody @Valid CategoryCommand command){
        if (null == command.getId()){
            categoryService.addCategory(command);
        }else {
            categoryService.updateCategory(command);
        }
        return new Result(true, StatusCode.OK,"新增商品分类成功");
    }

    /**
     * 商品分类列表
     * @param command
     * @return
     */
    @PostMapping("findCategoryList")
    public PageResult findCategoryList(@RequestBody @Valid CategoryCommand command){
        return categoryService.findCategoryList(command);
    }

    /**
     * 通过id查询商品分类
     */
    @PostMapping("findCategory")
    public Result findCategory(@RequestParam("id") Integer id){

        Category category = categoryService.findCategory(id);
        return new Result(true,StatusCode.OK,"查询成功",category);
    }

    /**
     *通过parentId查询商品分类列表
     */
    @PostMapping("/findListByParentId")
    public Result findListByParentId(@RequestParam("parentId") Integer parentId){

        List<Category> categoryList = categoryService.findListByParentId(parentId);
        return new Result(true,StatusCode.OK,"查询成功",categoryList);
    }

    /**
     * 通过id删除商品分类
     */
    @PostMapping("/deleteCategory")
    public Result deleteCategory(@RequestParam("id")Integer id){
        Integer num = categoryService.deleteCategory(id);
        if (num <=0){
            throw new GlobalExecption("删除失败");
        }
        return new Result(true,StatusCode.OK,"删除成功");
    }


}
