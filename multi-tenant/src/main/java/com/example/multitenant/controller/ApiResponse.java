package com.example.multitenant.controller;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class ApiResponse implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;

	private Boolean status;
	
	private String message;
	
	private String statusCode;
		
}
