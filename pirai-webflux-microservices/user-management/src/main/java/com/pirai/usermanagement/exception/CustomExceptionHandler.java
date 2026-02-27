package com.pirai.usermanagement.exception;

import com.pirai.usermanagement.constants.MessageKeyConstants;
import com.pirai.usermanagement.dto.response.ApiResponse;
import com.pirai.usermanagement.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        log.error("handleValidationExceptions :: {}", ex.getMessage());
        ApiResponse response = new ApiResponse();
        List<String> errors = ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).toList();
        String errorMessage = String.join(", ", errors);
        CommonUtils.failureCustomExceptionMessage(errorMessage, response);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<ApiResponse> handleInvalidUserExceptions(InvalidUserException ex) {
        ApiResponse response = getResponse(ex);
        CommonUtils.failureInvalidUserMessage(messageSource, response, null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse> handleCustomExceptions(CustomException ex) {
        return normalMessageException(ex, ex.getMessage());
    }

    private ResponseEntity<ApiResponse> normalMessageException(Exception ex, String message) {
        ApiResponse response = getResponse(ex);
        CommonUtils.failureCustomExceptionMessage(message, response);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> handleBadRequestExceptions(BadRequestException ex) {
        ApiResponse response = getResponse(ex);
        CommonUtils.failureBadRequestMessage(ex.getMessage(), messageSource, response, null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundExceptions(ResourceNotFoundException ex) {
        ApiResponse response = getResponse(ex);
        CommonUtils.failureResourceNotFoundMessage(ex.getMessage(), messageSource, response, null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleExceptions(Exception ex) {
        ApiResponse response = getResponse(ex);
        CommonUtils.failureInternalServerErrorMessage(MessageKeyConstants.INTERNAL_SERVER_ERROR, messageSource, response, null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    private ApiResponse getResponse(Exception ex) {
        StackTraceElement[] stackTrace = ex.getStackTrace();
        StackTraceElement st = Arrays.stream(stackTrace)
                .filter(s -> s.getClassName().toUpperCase().contains("service.impl".toUpperCase()))
                .findFirst().orElse(new StackTraceElement("", "", "", -1));
        log.error("{} :: {} - {} - line Number {} ", ex, st.getFileName(), st.getMethodName(), st.getLineNumber());
        return new ApiResponse();
    }

}
