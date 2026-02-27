package com.devsuperior.bds02.handlers;

import com.devsuperior.bds02.dto.error.CustomErrorDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    //ENTITY NOT FOUND EXCEPTION
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomErrorDto> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomErrorDto err = new CustomErrorDto(Instant.now(), status.value(), "Resource not found", request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    //DATA INTEGRATION EXCEPTION
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CustomErrorDto> dataIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomErrorDto err = new CustomErrorDto(Instant.now(), status.value(), "Data integrity violation", request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
