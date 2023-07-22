package com.jiwon.controller;

import com.jiwon.domain.ResultModel;
import com.jiwon.service.MemberService;
import com.jiwon.serviceImpl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity memberJoin(){
        ResultModel resultModel = new ResultModel();

        return ResponseEntity.ok().body("join");
    }

    @GetMapping("/id")
    public ResponseEntity memberIdCheck(
            @RequestParam("id")String id
            ){
        String result = memberService.memberIdCheck(id);

        Map<String, String> returnMap = new HashMap<>();

        if (result.equals("success")) {
            returnMap.put("msg", "사용 가능한 아이디입니다.");
            returnMap.put("status", "SUCCESS");
            return ResponseEntity.ok().body(returnMap);
        } else {
            returnMap.put("msg", "사용 불가능한 아이디입니다.");
            returnMap.put("status", "FAIL");
            return ResponseEntity.ok().body(returnMap);
        }
    }
    @PostMapping("/id")
    public ResponseEntity memberJoin(
            @RequestBody Map<String,Object> map
    ){
        Map<String,String> memberMap = (Map<String, String>) map.get("member");

        String result = memberService.memberJoin(memberMap);

        return ResponseEntity.ok().body(result);
    }
}
