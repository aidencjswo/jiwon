package com.jiwon.repository;


import com.jiwon.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
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

    @Test
    public void findMemberNameFromMemberId(){
        Optional<Member> result = memberRepository.getMemberFromId("aidencjswo");

        Member member = result.get();

        Assertions.assertThat(member.getName()).isEqualTo("안상영");
    }
}
