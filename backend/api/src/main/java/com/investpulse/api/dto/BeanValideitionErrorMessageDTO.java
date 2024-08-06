package com.investpulse.api.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeanValideitionErrorMessageDTO {
    Integer statusCode;
    String message;
    Map<String, String> errors;
}
