package dev.resms.model;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private String status;
    private ErrorDetails error;

    @Getter
    public static class ErrorDetails {
        private String name;
        private String message;
    }
}
