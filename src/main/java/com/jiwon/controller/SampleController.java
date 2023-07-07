package com.jiwon.controller;


import com.jiwon.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/test")
    public String test(){
        sampleService.serviceTest();
        return "/test.html";
    }


}
