package com.investpulse.api.dto;

import lombok.Data;

import java.time.Instant;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class UserResponseDTO {

    private String email;

    private String cpf;

    private String fullName;

    private String phoneNumber;

    private String investmentAdvisor;

    private Instant createdAt;

    private Instant updatedAt;
}
