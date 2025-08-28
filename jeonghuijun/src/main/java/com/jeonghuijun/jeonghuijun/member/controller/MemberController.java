package com.jeonghuijun.jeonghuijun.member.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.jeonghuijun.jeonghuijun.member.controller.dto.MemberCreateRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jeonghuijun.jeonghuijun.member.controller.dto.MemberResponse;
import com.jeonghuijun.jeonghuijun.member.entity.Member;
import com.jeonghuijun.jeonghuijun.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private static final DateTimeFormatter F = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    private final MemberService service;

    @PostMapping
    public ResponseEntity<MemberResponse> create(@Valid @RequestBody MemberCreateRequest req) {
        var m = service.create(req.email(), req.name());
        return ResponseEntity.ok(toResponse(m));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> get(@PathVariable Long id) {
        var m = service.get(id);
        return ResponseEntity.ok(toResponse(m));
    }

    @GetMapping
    public List<MemberResponse> list() {
        return service.list().stream().map(this::toResponse).toList();
    }

    @PostMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        service.deactivate(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private MemberResponse toResponse(Member m) {
        return new MemberResponse(
                m.getId(),
                m.getEmail(),
                m.getName(),
                m.getStatus().name(),
                F.format(m.getCreatedAt()),
                F.format(m.getUpdatedAt())
        );
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
