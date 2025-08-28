package com.jeonghuijun.jeonghuijun.member.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * json: {
 *     "email": "huijun@example.com",
 *     "name": "정희준"
 * }
 * @param email
 * @param name
 */

public record MemberCreateRequest(
        @NotBlank @Email String email,
        @NotBlank @Size(max = 50) String name
) { }
