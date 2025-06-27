package org.skypro.skyshop.exception.handler;

import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.exception.handler.dto.ShopError;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShopExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ShopError> handelAllExceptions (NoSuchProductException e){
        ShopError shopError = new ShopError(HttpStatus.NOT_FOUND.name(), e.getMessage());
        System.out.printf("Пойман %s%n", e.getMessage());
        return new ResponseEntity<>(shopError, HttpStatus.NOT_FOUND);
    }

}
