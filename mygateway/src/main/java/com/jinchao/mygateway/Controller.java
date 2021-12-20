package com.jinchao.mygateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: jinchao
 * @Date: 2021/12/12 - 21:27
 * @Description: com.jinchao.mygateway
 * @version: 1.0
 */
@RestController
public class Controller {

    @GetMapping(value = "/get")
    public String get(){
        return "hello,gateway!";
    }

}
