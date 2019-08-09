package com.example.demo.controller;

import com.example.demo.excetion.MyException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义错误页面信息
 */
@ControllerAdvice
public class MyExceptionHandler {


    /**
     * 1浏览器客户端返回的都是json
     * @param e
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(MyException.class)
//    public Map<String, Object> handlerExce(Exception e){
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","user >>>>>>>>");
//        map.put("message",e.getMessage());
//        return map;
//    }

    /**
     * 转发到error地址，通过boot内部视图解析器拿到放入静态文件夹的错误页面
     * 但是不能自定义错误信息
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(MyException.class)
    public String  handlerExce2 (Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        //传入自己的状态码（200），例如4xx
        //Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user >>>>>>>>");
        map.put("message",e.getMessage());
        return "forward:/error";
    }

}
