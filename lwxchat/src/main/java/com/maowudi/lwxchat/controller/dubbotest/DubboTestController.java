package com.maowudi.lwxchat.controller.dubbotest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.maowudi.chatapi.service.DubboTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboTestController {

    @Reference(check = false, timeout = 1000000)
    private DubboTest dubboTest;

    public static int count = 0;//访问量
    public static int okCount = 0;//成功访问量

    @RequestMapping("test")
    public String dubbotest(String hello){
        add1();
        String str = dubboTest.dubboTest(hello);
        add2();
        return str;
    }

    @RequestMapping("count")
    public String count(){
        return "总共访问数：" + count +";成功访问量：" + okCount;
    }

    private static synchronized void add1(){
        count++;
    }
    private static synchronized void add2(){
        okCount++;
    }
}
