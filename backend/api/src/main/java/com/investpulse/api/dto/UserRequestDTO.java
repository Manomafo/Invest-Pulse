package com.investpulse.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDTO {

    private String email;

    private int cpf;

    private String fullName;

    private int phoneNumber;

    private String password;

    private String investmentAdvisor;

}
