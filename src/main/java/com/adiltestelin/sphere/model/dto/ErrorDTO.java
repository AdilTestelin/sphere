package com.adiltestelin.sphere.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDTO {

    private int statusCode;

    private String httpStatus;

    private String exception;

    private String message;

    private Long timestamp;
}
