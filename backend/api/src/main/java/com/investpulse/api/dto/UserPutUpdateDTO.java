package com.investpulse.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPutUpdateDTO {

    @NotBlank(message = "O nome completo não pode ser vazio")
    @Size(min = 5, max = 50, message = "O nome completo deve ter entre 5 a 50 caracteres")
    private String fullName;

    @NotBlank(message = "A senha não pode ser vazia")
    @Size(min = 6, max = 50, message = "A senha deve ter entre 6 a 50 caracteres")
    private String password;
}
