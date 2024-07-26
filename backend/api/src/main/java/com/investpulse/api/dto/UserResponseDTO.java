package com.investpulse.api.dto;

import lombok.Data;

import java.time.Instant;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class UserResponseDTO {

    private String email;

    private int cpf;

    private String fullName;

    private int phoneNumber;

    private String investmentAdvisor;

    private Instant createdAt;

    private Instant updatedAt;
}
