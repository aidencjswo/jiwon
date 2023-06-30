package com.jiwon.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    @Column(length = 50 , nullable = false)
    private String memberId;
    @Column(length = 50 , nullable = false)
    private String memberPw;
    @Column(length = 30)
    private String token;
    @Column(length = 50 , nullable = false)
    private String salt;
    @Column(length = 50 , nullable = false)
    private String name;
}
