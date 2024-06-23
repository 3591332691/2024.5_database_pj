package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class frontendController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, world!");
        return "hello"; // 这里返回的是Thymeleaf模板的名称，不带扩展名
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login"; // 这里返回的是Thymeleaf模板的名称，不带扩展名
    }

    @GetMapping("/for_student")
    public String for_student(Model model) {
        return "for_student"; // 这里返回的是Thymeleaf模板的名称，不带扩展名
    }


    @GetMapping("/for_merchant")
    public String for_merchant(Model model) {
        return "for_merchant"; // 这里返回的是Thymeleaf模板的名称，不带扩展名
    }

}
