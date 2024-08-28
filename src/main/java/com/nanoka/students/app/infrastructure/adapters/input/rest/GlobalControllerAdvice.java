package com.nanoka.students.app.infrastructure.adapters.input.rest;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nanoka.students.app.domain.exception.StudentNotFoundException;
import com.nanoka.students.app.domain.model.ErrorResponse;
import com.nanoka.students.app.utils.ErrorCatelog;

@RestControllerAdvice
public class GlobalControllerAdvice {

        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(StudentNotFoundException.class)
        public ErrorResponse handleStudentNotFoundException() {
                return ErrorResponse.builder()
                                .code(ErrorCatelog.STUDENT_NOT_FOUND.getCode())
                                .message(ErrorCatelog.STUDENT_NOT_FOUND.getMessage())
                                .timestamp(LocalDateTime.now())
                                .build();
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ErrorResponse handleMethodArgumentNotValidException(
                        MethodArgumentNotValidException ex) {

                BindingResult result = ex.getBindingResult();

                return ErrorResponse.builder()
                                .code(ErrorCatelog.INVALID_STUDENT.getCode())
                                .message(ErrorCatelog.INVALID_STUDENT.getMessage())
                                .details(result.getFieldErrors()
                                                .stream()
                                                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                                .collect(Collectors.toList()))
                                .timestamp(LocalDateTime.now())
                                .build();
        }

        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        @ExceptionHandler(Exception.class)
        public ErrorResponse handleException(Exception ex) {
                return ErrorResponse.builder()
                                .code(ErrorCatelog.GENERIC_ERROR.getCode())
                                .message(ErrorCatelog.GENERIC_ERROR.getMessage())
                                .details(Collections.singletonList(ex.getMessage()))
                                .timestamp(LocalDateTime.now())
                                .build();
        }
}
