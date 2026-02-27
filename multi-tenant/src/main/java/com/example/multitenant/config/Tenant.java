package com.example.multitenant.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tenant {

    private Long id;
    private String tenantId;
    private String driver;
    private Integer port;
    private String dbUrl;
    private String dbName;
    private String dbUsername;
    private String dbPassword;

}
