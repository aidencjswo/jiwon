package com.jiwon.controller;

import com.jiwon.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class MemberControllerTests {

    @Autowired
    private MemberRepository memberRepository;


    @Test
    void memberJoinTest(){

    }

    @Test
    void memberLoginTest(){

    }

}
