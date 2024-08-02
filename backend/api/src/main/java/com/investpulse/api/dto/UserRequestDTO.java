package com.investpulse.api.dto;

import com.investpulse.api.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDTO {

    private String email;

    private String cpf;

    private String fullName;

    private String phoneNumber;

    private String password;

    private String investmentAdvisor;

    public User toUser() {
        return new User(this);
    }

}
