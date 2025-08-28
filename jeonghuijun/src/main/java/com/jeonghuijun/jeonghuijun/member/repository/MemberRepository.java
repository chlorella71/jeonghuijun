package com.jeonghuijun.jeonghuijun.member.repository;

import com.jeonghuijun.jeonghuijun.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    boolean existsByEmailIgnoreCase(String email);
}
