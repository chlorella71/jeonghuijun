package com.jeonghuijun.jeonghuijun.member.service;

import com.jeonghuijun.jeonghuijun.member.entity.Member;
import com.jeonghuijun.jeonghuijun.member.entity.MemberStatus;
import com.jeonghuijun.jeonghuijun.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository members;

    public Member create(String email, String name) {
        var normalized = normalizeEmail(email);
        if (members.existsByEmailIgnoreCase(normalized)) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }
        var m = Member.builder()
                .email(normalized)
                .name(name.trim())
                .status(MemberStatus.ACTIVE)
                .createdAt(OffsetDateTime.now())
                .updatedAt(OffsetDateTime.now())
                .build();
        return members.save(m);
    }

    @Transactional(readOnly = true)
    public Member get(Long id) {
        return members.findById(id).orElseThrow(() -> new IllegalArgumentException("회원이 없습니다."));
    }

    @Transactional(readOnly = true)
    public List<Member> list() {
        return members.findAll();
    }

    public void deactivate(Long id) {
        var m = get(id);
        m.deactivate();
    }

    public void delete(Long id) {
        var m = get(id);
        m.delete();
    }

    private static String normalizeEmail(String email) {
        if (email == null) throw new IllegalArgumentException("email required");
        return email.trim().toLowerCase();
    }
}
