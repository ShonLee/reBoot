package com.shonlee.reboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther shonlee
 * @Create 2018/5/11
 */
@RestController
@RequestMapping("/")
public class TestController {
    @GetMapping("test")
    public String test() {
        System.out.println("hello word ");
        return "hello word";
    }
}
