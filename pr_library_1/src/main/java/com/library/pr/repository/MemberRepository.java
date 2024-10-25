package com.library.pr.repository;

import com.library.pr.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
//id와 username을 통해 조회??
public interface MemberRepository extends JpaRepository<Member,  Long> {

    @EntityGraph(attributePaths = "roleSet")
    @Query("select m from Member m where m.username = :username")
    Optional<Member> getWithRole(String username);

    boolean existsByUsername(String username); // username으로 검색하는 메소드
}
