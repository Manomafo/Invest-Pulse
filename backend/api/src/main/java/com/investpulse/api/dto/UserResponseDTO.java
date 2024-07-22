package com.investpulse.api.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class UserResponseDTO {

    private String email;

    private String fullName;

    private int phoneNumber;

    private String investmentAdvisor;

}
