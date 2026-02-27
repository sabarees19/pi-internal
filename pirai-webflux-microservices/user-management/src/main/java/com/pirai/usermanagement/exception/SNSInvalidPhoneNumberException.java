package com.pirai.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SNSInvalidPhoneNumberException extends RuntimeException{
    private static final long serialVersionUID = 1L;

	public SNSInvalidPhoneNumberException(){
        super("Invalid phoneNumber format");
    }
}
