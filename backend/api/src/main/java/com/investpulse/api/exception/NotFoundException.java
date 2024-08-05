package com.investpulse.api.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    String description;

    public NotFoundException() {
        super("Usuário não encontrado");
        this.description = "Não foi possivel encontrar ou recuperar o usuário";
    }

    public NotFoundException(String message, String description) {
        super(message);
        this.description = description;
    }

}
