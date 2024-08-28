package com.nanoka.students.app.utils;

import lombok.Getter;

@Getter
public enum ErrorCatelog {

    STUDENT_NOT_FOUND("ERR_STUDENT_001", "Studen not found."),
    INVALID_STUDENT("ERR_STUDENT_002", "Invalid student parameters."),
    GENERIC_ERROR("ERR_GEN_001", "An unexpected error occurred");

    private final String code;
    private final String message;

    ErrorCatelog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
