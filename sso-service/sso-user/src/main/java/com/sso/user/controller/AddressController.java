package com.sso.user.controller;


import com.sso.user.model.Address;
import com.sso.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuyang
 * @since 2020-07-12
 */
@RestController
@RequestMapping("/user/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("/findById")
    public Address findById(@RequestParam("id") String id){
        return addressService.findById(id);
    }
}
