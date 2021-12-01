package com.first.hellospring.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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
        return hello;
    }

    @Data // lombok
    static class Hello {
        private String name;
    }
}
