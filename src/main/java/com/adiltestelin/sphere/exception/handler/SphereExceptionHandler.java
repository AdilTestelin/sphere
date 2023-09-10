package com.adiltestelin.sphere.exception.handler;

import com.adiltestelin.sphere.exception.MailAlreadyExistsException;
import com.adiltestelin.sphere.exception.UsernameAlreadyExistsException;
import com.adiltestelin.sphere.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SphereExceptionHandler {

    @ExceptionHandler(value = MailAlreadyExistsException.class)
    private ResponseEntity<ErrorDTO> handleMailAlreadyExistsException(MailAlreadyExistsException ex) {
        ErrorDTO error = ErrorDTO.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .httpStatus(HttpStatus.BAD_REQUEST.name())
                .exception(ex.getCause().toString())
                .message(ex.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.badRequest().body(error);
    }
    @ExceptionHandler(value = UsernameAlreadyExistsException.class)
    private ResponseEntity<ErrorDTO> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException ex) {
        ErrorDTO error = ErrorDTO.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .httpStatus(HttpStatus.BAD_REQUEST.name())
                .exception(ex.getCause().toString())
                .message(ex.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.badRequest().body(error);
    }

}
