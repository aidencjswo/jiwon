package com.jiwon.controller;

import com.jiwon.domain.Member;
import com.jiwon.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootTest
@Log4j2
public class MemberControllerTests {


    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void memberJoinTest(){
        Member member = Member.builder()
                .memberId("aidencjswo1")
                .memberPw(passwordEncoder.encode("1234"))
                .name("안상영")
                .build();

        Member result = memberRepository.save(member);
    }

    @Test
    void memberLoginTest(){

    }

    @Test
    void memberIdCheckTest(){
        int result = memberRepository.checkMemberById("aidencjswo5");

        log.info(result);
    }

}
