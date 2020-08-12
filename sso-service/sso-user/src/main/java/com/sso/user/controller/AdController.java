package com.sso.user.controller;


import com.sso.user.model.Ad;
import com.sso.user.service.AdService;
import com.sso.common.entity.Result;
import com.sso.common.entity.StatusCode;
import com.sso.file.controller.FileController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuyang
 * @since 2020-08-05
 */
@RestController
@RequestMapping("/ad")
public class AdController {

    @Autowired
    private  AdService adService;

    @PostMapping("/saveAd")
    public Result saveAd(@RequestBody Ad ad, @RequestParam MultipartFile file){
        //adService.saveAd(ad);
        FileController fileController = new FileController();
        Result result = fileController.uploadFile(file);
        String data = (String) result.getData();
        ad.setUrl(data);
        adService.saveAd(ad);
        return new Result(true, StatusCode.OK,"添加广告成功");
    }

}
