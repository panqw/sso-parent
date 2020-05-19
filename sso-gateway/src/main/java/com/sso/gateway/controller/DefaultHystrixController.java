package com.sso.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 默认降级处理
 */
@RestController
public class DefaultHystrixController {

    @RequestMapping("/defaultfallback")
    public Map<String,String> defaultfallback(){
        Map<String,String> map = new LinkedHashMap<>();
        map.put("code", HttpStatus.SERVICE_UNAVAILABLE+"");
        map.put("message","网络开了小差");
        return map;
    }
}