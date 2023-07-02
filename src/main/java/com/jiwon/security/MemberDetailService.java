package com.jiwon.security;

import com.jiwon.domain.Member;
import com.jiwon.dto.MemberDTO;
import com.jiwon.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> result = memberRepository.findById(username);

        Member member = result.orElseThrow(() -> new UsernameNotFoundException("Cannot find mid"));

        log.info("APIUserDetailsService apiUser--------------------------");

        MemberDTO dto = new MemberDTO(
                member.getMemberId(),
                member.getMemberPw(),
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
        log.info(dto);

        return dto;
    }
}
