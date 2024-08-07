package com.investpulse.api.exception;

import lombok.Getter;

@Getter
public class EntityAlreadyExistsException extends RuntimeException {
    String description;

    public EntityAlreadyExistsException() {
        super("Usuário já existe");
        this.description = "Já existe um usuário com este email ou número de telefone";
    }

    public EntityAlreadyExistsException(String message, String description) {
        super(message);
        this.description = description;
    }
}
