package com.investpulse.api.dto;

import com.investpulse.api.model.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "O e-mail não pode ser vazio")
    @Email(message = "O e-mail deve ser valido")
    private String email;

    @NotBlank(message = "O CPF não pode ser vazio")
    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 caracteres")
    private String cpf;

    @NotBlank(message = "O nome completo não pode ser vazio")
    @Size(min = 5, max = 50, message = "O nome completo deve ter entre 5 a 50 caracteres")
    private String fullName;

    @NotBlank(message = "O numero de telefone não pode ser vazio")
    @Size(min = 10, max = 11, message = "O numero de telefone deve ter de 10 ou 11 caracteres")
    private String phoneNumber;

    @NotBlank(message = "A senha não pode ser vazia")
    @Size(min = 6, max = 50, message = "A senha deve ter entre 6 a 50 caracteres")
    private String password;

    public User toUser() {
        return new User(this);
    }

}
