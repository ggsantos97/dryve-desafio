package com.dryve.dryvecarros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ExceptionInterceptor  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ErroNegocialException.class})
    protected ResponseEntity<Object> handleErroNegocialExceptions(ErroNegocialException ex, WebRequest request){
        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(value = {ObjetoNaoEncontradoException.class})
    protected ResponseEntity<Object> handleObjetoNaoEncontradoExceptions(ObjetoNaoEncontradoException ex, WebRequest request){
        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
