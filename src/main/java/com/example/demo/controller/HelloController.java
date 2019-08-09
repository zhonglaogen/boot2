package com.example.demo.controller;

import com.example.demo.excetion.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new MyException("用户是aaa");
        }
        return "hello";
    }

    @RequestMapping(value = "/thymeleaf")
    public String thymeleaf(Map<String,Object> map){
        map.put("zlx","zhonglianxi");
        return "myhtml";
    }

    //在配置类写了
//    @RequestMapping(value = {"/","index.html"})
//    public String index(){
//        return "index";
//    }

}


