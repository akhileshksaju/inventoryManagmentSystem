package com.akhi.microservices.product.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.akhi.microservices.product.Exceptions.ResourceAlreadyExistsException;

@ControllerAdvice
public class ExceptionHandling {

  @ExceptionHandler(ResourceAlreadyExistsException.class)
  public ResponseEntity<Map<String, String>> handleResourceAlreadyExists(ResourceAlreadyExistsException ex) {
    Map<String, String> error = new HashMap<>();
    error.put("error", "Resource already exists");
    error.put("message", ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.CONFLICT); // 409
  }

}
