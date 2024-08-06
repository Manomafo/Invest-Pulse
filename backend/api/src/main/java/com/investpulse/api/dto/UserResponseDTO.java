package com.investpulse.api.dto;

import lombok.Data;

import java.time.Instant;

import com.investpulse.api.model.User;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class UserResponseDTO {

    private String email;

    private String cpf;

    private String fullName;

    private String phoneNumber;

    private Instant createdAt;

    private Instant updatedAt;

    public UserResponseDTO(User user) {
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.fullName = user.getFullName();
        this.phoneNumber = user.getPhoneNumber();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}
