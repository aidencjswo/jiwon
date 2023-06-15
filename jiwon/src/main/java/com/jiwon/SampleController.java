package com.jiwon;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jiwon")
public class SampleController {

    @GetMapping("/love")
    public String test(){
        System.out.println("test");
        return "/test.html";
    }
}
