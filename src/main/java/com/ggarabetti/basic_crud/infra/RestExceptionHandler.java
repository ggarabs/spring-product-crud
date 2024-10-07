package com.ggarabetti.basic_crud.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ggarabetti.basic_crud.exceptions.ProductNotActiveException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotActiveException.class)
    private ResponseEntity productNotActiveHandler(ProductNotActiveException exception) {
        RestErrorMessage threatedResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(threatedResponse);
    }
}
