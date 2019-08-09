package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    /**
     * 不提交RequestParam就会报错
     * @param userName
     * @param password
     * @return
     */
    @PostMapping(value ="/user/login" )
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("passWord") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if(userName!=null && password.equals("123")){
            //防止刷新，表单重复提交，重定向页面,重定向和视图解析路径不一样，资源能正常拿到
            session.setAttribute("loginuser",userName);
            return "redirect:/main.html";
        }
        map.put("msg","error");
        return "index";

    }
}
