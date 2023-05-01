package com.example.testerrorrsgayclub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExceptionResponseDto {
    private String title;
    private String message;
    private int code;
}
