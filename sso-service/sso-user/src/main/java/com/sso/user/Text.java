package com.sso.user;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Text {
    public static void main(String[] args) throws UnknownHostException {


        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);

        Integer i= 0X12AB;
    }
}
