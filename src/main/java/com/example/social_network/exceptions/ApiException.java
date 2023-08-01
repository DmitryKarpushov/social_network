package com.example.social_network.exceptions;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author Дмитрий Карпушов 31.07.2023
 */
@Getter
@Builder(access = AccessLevel.PRIVATE, builderMethodName = "internalBuilder")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiException extends RuntimeException {

    public static class ApiExceptionBuilder {

        private static ApiExceptionBuilder builder() {
            return ApiException.internalBuilder();
        }

        private static ApiExceptionBuilder builder(Exception e) {
            return builder().sourceMessage(e.getMessage());
        }

        public ApiException notFound(String message) {
            return this.message(message)
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        public ApiException conflict(String message) {
            return this.message(message)
                    .status(HttpStatus.CONFLICT)
                    .build();
        }
    }

    public static ApiExceptionBuilder builder(Exception e) {
        return ApiExceptionBuilder.builder(e);
    }

    public static ApiExceptionBuilder builder() {
        return ApiExceptionBuilder.builder();
    }

    public enum ApiExceptionAction {
        NO_ACTION, REDIRECT_HOME;
    }

    private final String message;

    private final String sourceMessage;

    private final HttpStatus status;

    private final LocalDateTime timestamp = LocalDateTime.now();
    @Builder.Default
    private final ApiExceptionAction action = ApiExceptionAction.NO_ACTION;
}
