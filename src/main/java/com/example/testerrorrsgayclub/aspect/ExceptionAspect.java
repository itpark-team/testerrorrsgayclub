package com.example.testerrorrsgayclub.aspect;

import com.example.testerrorrsgayclub.dto.ExceptionResponseDto;
import com.example.testerrorrsgayclub.errors.ServerException;
import com.example.testerrorrsgayclub.errors.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionAspect {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ExceptionResponseDto> handleUserException(UserException exception) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(exception.getTitle(), exception.getMessage(), exception.getCode());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<ExceptionResponseDto> handleServerException(ServerException exception) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(exception.getTitle(), exception.getMessage(), exception.getCode());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto("Validation error", errors.toString(), 0);

        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleException(Exception e) {
        StringWriter out = new StringWriter();
        PrintWriter writer = new PrintWriter(out);

        e.printStackTrace(writer);

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto("Не отслеживаемая ошибка", e.toString() + ": " + out.toString(), 0);
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_IMPLEMENTED);
    }
}
