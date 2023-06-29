package com.jiwon.controller;


import com.jiwon.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

    private SampleService sampleService;

    @GetMapping("/test")
    public String test(){
        sampleService.serviceTest();
        return "/test.html";
    }
}
