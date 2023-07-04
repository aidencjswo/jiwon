package com.jiwon.repository;

import com.jiwon.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    //@EntityGraph(attributePaths = "roleSet")
    @Query("select m from Member m where m.memberId = :memberId and m.social = false")
    Optional<Member> getWithRoles(String memberId);
}
