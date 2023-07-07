package com.jiwon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/view/")
public class JWTTestController {
    @GetMapping("test")
    public List<String> test(){
        return Arrays.asList("APEX","IS","OVER");
    }
}
