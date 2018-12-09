package com.example.springboottest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/user")
public class UserController {
    @GetMapping("/name")
    private String name(){
        return "name";
    }
    @GetMapping("return")
    private String  returnIt(@RequestParam String name){
        return name;
    }
}
