package com.jiwon.repository;


import com.jiwon.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@RequiredArgsConstructor
public class MemberRepository {

    private final MemberRepository memberRepository;

    @Test
    public void testInsert(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Member member = Member.builder()
                    .build();
        });
    }
}
