package com.first.hellospring.controller;

import com.first.hellospring.HelloSpringApplication;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    public void hello(Model model) {
        model.addAttribute("data", "Hello!!!");
    }

    @GetMapping("/hello-api")
    @ResponseBody // api
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        log.info("접속 성공");
        return hello;
    }

    @Data // lombok
    static class Hello {
        private String name;
    }
}
