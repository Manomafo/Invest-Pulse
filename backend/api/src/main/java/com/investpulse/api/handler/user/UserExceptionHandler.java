package com.investpulse.api.handler.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.investpulse.api.dto.BeanValideitionErrorMessageDTO;
import com.investpulse.api.dto.DefaultErrorMessageDTO;
import com.investpulse.api.exception.EntityAlreadyExistsException;
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

    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseBody
    public ResponseEntity<DefaultErrorMessageDTO> handlerEntityAlreadyExistsExceptoin(
            EntityAlreadyExistsException exception) {
        DefaultErrorMessageDTO errorDTO = new DefaultErrorMessageDTO(HttpStatus.CONFLICT.value(),
                exception.getMessage(), exception.getDescription());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDTO);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {

            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        BeanValideitionErrorMessageDTO errorDTO = new BeanValideitionErrorMessageDTO(
                HttpStatus.BAD_REQUEST.value(), "Erro de validação", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }
}
