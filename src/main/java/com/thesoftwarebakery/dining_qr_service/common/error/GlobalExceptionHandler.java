package com.thesoftwarebakery.dining_qr_service.common.error;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final String KEY_STATUS = "status";
    private final String KEY_ERROR = "error";
    private final String KEY_MESSAGE = "message";
    private final String KEY_TIMESTAMP = "timestamp";

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(createResponseBody(404, ErrorCode.NOT_FOUND.name(), ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> messages = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
        return ResponseEntity.badRequest().body(createResponseBody(400, ErrorCode.VALIDATION_ERROR.name(), messages));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleInvalidEnumError(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof IllegalArgumentException) {
            return ResponseEntity.badRequest()
                    .body(createResponseBody(400, ErrorCode.INVALID_ENUM_VALUE.name(), "Invalid value passed."));
        }
        return ResponseEntity.badRequest()
                .body(createResponseBody(400, ErrorCode.INVALID_REQUEST_BODY.name(), "Malformed JSON request"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralError(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(createResponseBody(500, ErrorCode.INTERNAL_SERVER_ERROR.name(), "An unexpected error occurred."));
    }

    private Map<String, Object> createResponseBody(int status, String error, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put(KEY_STATUS, status);
        body.put(KEY_ERROR, error);
        body.put(KEY_MESSAGE, message);
        body.put(KEY_TIMESTAMP, LocalDateTime.now());
        return body;
    }

    private Map<String, Object> createResponseBody(int status, String error, List<String> message) {
        Map<String, Object> body = new HashMap<>();
        body.put(KEY_STATUS, status);
        body.put(KEY_ERROR, error);
        body.put(KEY_MESSAGE, message);
        body.put(KEY_TIMESTAMP, LocalDateTime.now());
        return body;
    }
}
