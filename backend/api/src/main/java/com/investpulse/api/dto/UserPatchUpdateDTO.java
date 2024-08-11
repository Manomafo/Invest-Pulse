package com.investpulse.api.dto;

import com.investpulse.api.validation.NotEmptyOrSpacesOnly;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserPatchUpdateDTO {

    @Size(min = 5, max = 50, message = "O nome completo deve ter entre 5 a 50 caracteres")
    @NotEmptyOrSpacesOnly(message = "O nome completo não pode ser apenas o caracater de spaço ou vazio")
    private String fullName;

    @Size(min = 6, max = 50, message = "A senha deve ter entre 6 a 50 caracteres")
    @NotEmptyOrSpacesOnly(message = "A senha não pode ser apenas o caracater de spaço ou vazio")
    private String password;

}
