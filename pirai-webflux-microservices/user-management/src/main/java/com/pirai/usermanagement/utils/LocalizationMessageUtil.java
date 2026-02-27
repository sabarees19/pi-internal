package com.pirai.usermanagement.utils;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class LocalizationMessageUtil {

    private LocalizationMessageUtil() {
    }

    public static LocalizationMessageUtil getInstance() {
        return new LocalizationMessageUtil();
    }

    public String getMessageInfo(Locale locale, String messageKey, MessageSource messageSource) {
        return messageSource.getMessage(messageKey, null, locale);
    }

}
