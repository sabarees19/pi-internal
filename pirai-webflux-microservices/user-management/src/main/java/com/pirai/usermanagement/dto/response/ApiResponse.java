package com.pirai.usermanagement.dto.response;

import java.io.Serial;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;

	private Boolean status;
	
	private String message;
	
	private String statusCode;
		
}
