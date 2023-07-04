package com.jiwon.repository;


import com.jiwon.domain.Member;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testInsert(){

        Member member = Member.builder()
                .name("썬칩")
                .memberId("aidencjswo5")
                .memberPw(passwordEncoder.encode("1234"))
                .build();

        memberRepository.save(member);
    }
}
