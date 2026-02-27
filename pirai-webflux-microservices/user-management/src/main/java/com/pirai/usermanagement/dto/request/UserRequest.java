package com.pirai.usermanagement.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest extends BasicRequest {

    private String userName;

    private String emailId;

}
