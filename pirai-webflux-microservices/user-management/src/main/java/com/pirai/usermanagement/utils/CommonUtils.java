package com.pirai.usermanagement.utils;

import com.pirai.usermanagement.constants.MessageKeyConstants;
import com.pirai.usermanagement.dto.request.BasicRequest;
import com.pirai.usermanagement.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * This is a utility file for all common operations
 */
@Component
@Slf4j
public class CommonUtils {

    private CommonUtils() {
    }

    private static <T extends ApiResponse> void buildSuccessMethod(String messageKey, String responseCodeKey,
                                                                   MessageSource messageSource, T response, BasicRequest request) {
        buildResponse(messageKey, responseCodeKey, messageSource, response, request);
        response.setStatus(Boolean.TRUE);
    }

    private static <T extends ApiResponse> void buildFailureMethod(String messageKey, String responseCodeKey,
                                                                   MessageSource messageSource, T response, BasicRequest request) {
        buildResponse(messageKey, responseCodeKey, messageSource, response, request);
        response.setStatus(Boolean.FALSE);
    }

    private static <T extends ApiResponse> void buildResponse(String messageKey, String responseCodeKey,
                                                              MessageSource messageSource, T response, BasicRequest request) {
        Locale locale = getLocale(request);
        response.setMessage(getMessageInfo(locale, messageKey, messageSource));
        response.setStatusCode(getMessageInfo(locale, responseCodeKey, messageSource));
    }

    public static String getMessageInfo(Locale locale, String messageKey, MessageSource messageSource) {
        LocalizationMessageUtil instance = LocalizationMessageUtil.getInstance();
        // Call a method on the Singleton instance
        return instance.getMessageInfo(locale, messageKey, messageSource);
    }

    public static Locale getLocale(BasicRequest request) {
        if (ValidateUtil.isNullEmpty(request) || ValidateUtil.isNullEmpty(request.getLanguageCode())) {
            return new Locale.Builder().setLanguage("en").setRegion("US").build();
        } else {
            return new Locale.Builder().setLanguage(request.getLanguageCode()).setRegion(request.getCountryCode()).build();
        }
    }

    public static <T extends ApiResponse> T successMessage(String messageKey, MessageSource messageSource, T response,
                                                           BasicRequest request) {
        buildSuccessMethod(messageKey, MessageKeyConstants.ERROR_CODE_200, messageSource, response, request);
        response.setStatus(Boolean.TRUE);
        return response;
    }

    public static <T extends ApiResponse> void failureBadRequestMessage(String messageKey, MessageSource messageSource,
                                                                        T response, BasicRequest request) {
        buildFailureMethod(messageKey, MessageKeyConstants.ERROR_CODE_400, messageSource, response, request);
    }

    public static <T extends ApiResponse> void failureResourceNotFoundMessage(String messageKey,
                                                                              MessageSource messageSource, T response, BasicRequest request) {
        buildFailureMethod(messageKey, MessageKeyConstants.ERROR_CODE_404, messageSource, response, request);
    }

    public static <T extends ApiResponse> void failureInvalidUserMessage(MessageSource messageSource, T response,
                                                                         BasicRequest request) {
        buildFailureMethod(MessageKeyConstants.INVALID_TOKEN, MessageKeyConstants.ERROR_CODE_403,
                messageSource, response, request);
    }

    public static <T extends ApiResponse> T failureConflictMessage(String messageKey, MessageSource messageSource,
                                                                   T response, BasicRequest request) {
        buildFailureMethod(messageKey, MessageKeyConstants.ERROR_CODE_400, messageSource, response, request);
        return response;
    }

    public static <T extends ApiResponse> T failureInternalServerErrorMessage(String messageKey,
                                                                              MessageSource messageSource, T response, BasicRequest request) {
        buildFailureMethod(messageKey, MessageKeyConstants.ERROR_CODE_500, messageSource, response, request);
        return response;
    }

    public static <T extends ApiResponse> T failureCustomExceptionMessage(String message, T response) {
        response.setMessage(message);
        response.setStatusCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        response.setStatus(Boolean.FALSE);
        return response;
    }

}
