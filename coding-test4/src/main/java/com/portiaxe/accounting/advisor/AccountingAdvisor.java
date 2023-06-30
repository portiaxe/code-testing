package com.portiaxe.accounting.advisor;

import com.portiaxe.accounting.dto.GenericResponse;
import com.portiaxe.accounting.exception.AccountNotFoundException;
import com.portiaxe.accounting.exception.InvalidTransactionException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class AccountingAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            AccountNotFoundException.class,
            InvalidTransactionException.class,
            Exception.class
    })
    public ResponseEntity<Object> handleException(Exception e) {

        if(e instanceof AccountNotFoundException || e instanceof InvalidTransactionException){
            return ResponseEntity.status(400).body(new GenericResponse(400, e.getMessage()));
        }

        return ResponseEntity.status(500).body(new GenericResponse(500, "Internal server error"));

    }
}
