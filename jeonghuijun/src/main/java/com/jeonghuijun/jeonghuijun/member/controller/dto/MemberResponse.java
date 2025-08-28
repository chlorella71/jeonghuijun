package com.jeonghuijun.jeonghuijun.member.controller.dto;

/**
 * Json: {
 *     "id": 1,
 *     "email": "huijun@example.com",
 *     "name":" 정희준,
 *     "status": "ACTIVE",
 *     "createdAt" : "2025-08-28T12:34:56+09:00",
 *     "updatedAt" : "2025-08-28T12:34:56+09:00"
 * }
 * @param id
 * @param email
 * @param name
 * @param status
 * @param createdAt
 * @param updatedAt
 */

public record MemberResponse(
        Long id,
        String email,
        String name,
        String status,
        String createdAt,
        String updatedAt
) {}
