package com.jiwon.repository;


import com.jiwon.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testInsert(){

        Member member = Member.builder()
                .name("안상영")
                .memberId("aidencjswo")
                .memberPw("1234")
                .build();

        Member result = memberRepository.save(member);
    }
}
