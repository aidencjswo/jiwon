package com.jiwon.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity{

    /*
    nullable
    true : null을 허용
    false : null을 허용하지 않음
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 50 , nullable = false)
    private String memberId;

    @Column(length = 100 , nullable = false)
    private String memberPw;
    @Column(length = 30,unique = true)
    private String token;
    @Column(length = 50 , nullable = true)
    private String salt;
    @Column(length = 50 , nullable = false)
    private String name;
}
