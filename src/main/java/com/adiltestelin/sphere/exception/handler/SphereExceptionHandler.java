package com.adiltestelin.sphere.exception.handler;

import com.adiltestelin.sphere.exception.MailAlreadyExistsException;
import com.adiltestelin.sphere.exception.UsernameAlreadyExistsException;
import com.adiltestelin.sphere.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SphereExceptionHandler {

    @ExceptionHandler(value = MailAlreadyExistsException.class)
    private ResponseEntity<ErrorDTO> handleMailAlreadyExistsException(MailAlreadyExistsException ex) {
        final ErrorDTO error = ErrorDTO.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .httpStatus(HttpStatus.BAD_REQUEST.name())
                .exception(ex.getClass().getSimpleName())
                .message(ex.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(value = UsernameAlreadyExistsException.class)
    private ResponseEntity<ErrorDTO> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException ex) {
        final ErrorDTO error = ErrorDTO.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .httpStatus(HttpStatus.BAD_REQUEST.name())
                .exception(ex.getClass().getSimpleName())
                .message(ex.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    private ResponseEntity<ErrorDTO> handleIllegalArgumentException(BadCredentialsException ex) {
        final ErrorDTO error = ErrorDTO.builder()
                .statusCode(HttpStatus.FORBIDDEN.value())
                .httpStatus(HttpStatus.FORBIDDEN.name())
                .exception(ex.getClass().getSimpleName())
                .message(ex.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.status(403).body(error);
    }

}
