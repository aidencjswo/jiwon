package com.jiwon.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@ToString
public class MemberDTO extends User {

    private String memberId;
    private String memberPw;
    public MemberDTO(String username, String password, Collection<GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.memberId = username;
        this.memberPw = password;
    }
}
