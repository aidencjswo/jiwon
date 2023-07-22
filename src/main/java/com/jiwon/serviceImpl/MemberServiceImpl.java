package com.jiwon.serviceImpl;

import com.jiwon.domain.Member;
import com.jiwon.repository.MemberRepository;
import com.jiwon.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public String memberIdCheck(String id) {

        int result = memberRepository.checkMemberById(id);

        String resultMsg = "";

        if(result == 0){
            resultMsg = "success";
        }else{
            resultMsg = "fail";
        }

        return resultMsg;
    }

    @Override
    public String memberJoin(Map<String, String> memberMap) {

        Member member = Member.builder()
                .memberId(memberMap.get("id"))
                .memberPw(passwordEncoder.encode(memberMap.get("pw")))
                .name(memberMap.get("nm"))
                .build();

        Optional<Member> result = Optional.of(memberRepository.save(member));

        return null;
    }
}
