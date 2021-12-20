package com.jinchao.gatewaytest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: jinchao
 * @Date: 2021/12/13 - 21:28
 * @Description: com.jinchao.gatewaytest
 * @version: 1.0
 */
@RestController
public class Controller {

    @GetMapping(value = "/api/gateway/get")
    public String get(){
        return "hello,gateway!";
    }

    @GetMapping(value = "/parms")
    public String parms(String num){
        return "返回数字参数："+num;
    }

}
