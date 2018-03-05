package com.dubo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloWorldController {
    @RequestMapping("/test")
    public String getTest(){
        return "index";
    }
    @RequestMapping("/ajax")
    public void test(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println("什么情况");
        try {
            response.getWriter().print("成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
