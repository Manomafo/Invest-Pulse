package com.investpulse.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserPostLoginDTO {

    @NotBlank(message = "O e-mail não pode ser vazio")
    @Email(message = "O e-mail deve ser valido")
    private String email;

    @NotBlank(message = "A senha não pode ser vazia")
    @Size(min = 6, max = 50, message = "A senha deve ter entre 6 a 50 caracteres")
    private String password;

}
