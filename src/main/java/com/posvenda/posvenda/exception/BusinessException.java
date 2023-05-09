package com.posvenda.posvenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BusinessException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PagamentoException.class)
    public ResponseEntity<?> pagamentoException(PagamentoException pagamentoException){
        var details = new ExceptionDetails();
        details.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        details.setMessage(pagamentoException.getMessage());
        return new ResponseEntity<>(details, HttpStatus.UNPROCESSABLE_ENTITY);

    }



}
