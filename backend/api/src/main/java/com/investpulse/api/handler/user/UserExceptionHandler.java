package com.investpulse.api.handler.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.investpulse.api.dto.DefaultErrorMessageDTO;
import com.investpulse.api.exception.NotFoundException;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<DefaultErrorMessageDTO> handlerNotFoundException(NotFoundException exception) {
        DefaultErrorMessageDTO errorDTO = new DefaultErrorMessageDTO(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), exception.getDescription());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}
