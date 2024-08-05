package com.investpulse.api.dto;

import lombok.Getter;

@Getter
public class DefaultErrorMessageDTO {
    Integer statusCode;
    String message;
    String description;

    public DefaultErrorMessageDTO(Integer statusCode, String message, String description) {
        this.statusCode = statusCode;
        this.message = message;
        this.description = description;
    }
}
