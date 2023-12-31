package com.jiwon.repository;

import com.jiwon.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {


    @Query("select m from Member m where m.memberId = :memberId")
    Optional<Member> getWithRoles(@Param("memberId") String memberId);

    @Query("select count(m) from Member m where m.memberId = :memberId")
    int checkMemberById(@Param("memberId") String memberId);
}
