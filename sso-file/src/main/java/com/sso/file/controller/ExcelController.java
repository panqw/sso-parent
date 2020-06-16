package com.sso.file.controller;

import com.sso.common.entity.Result;
import com.sso.file.entity.SysDictItem;
import com.sso.file.util.ExcelUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @RequestMapping("/excelInput")
    @ResponseBody
    public Result ExcelInput(MultipartFile upfile){

        String file=upfile.getOriginalFilename();
        long size=upfile.getSize();
        if(StringUtils.isEmpty(file)||size==0){
            return new Result(false,500,"上传文件失败");
        }

        final String fileName ="C:/Users/Administrator/Desktop/"+file;

        InputStream inputStream = null;
        Result result = null;
        try {
            inputStream = new FileInputStream(new File(fileName));
            //属性名数组
            String[] dataIndexs = {
                    "dataType"
                    , "dataKey"
                    , "dataValue"
                    , "dispOrder"

            };
            //解析EXCEL文件
            List<SysDictItem> list = ExcelUtils.load(dataIndexs, SysDictItem.class, inputStream);
            for (SysDictItem sysDictItem : list) {
                sysDictItem.setUpdateTime(new Date());
            }
            //导入数据
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Assert.notNull(result);


        return new Result();
    }
}
