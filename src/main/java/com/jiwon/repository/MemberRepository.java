package com.jiwon.repository;

import com.jiwon.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {


    @Query("select m from Member m where m.memberId = :memberId")
    Optional<Member> getWithRoles(String memberId);
}
