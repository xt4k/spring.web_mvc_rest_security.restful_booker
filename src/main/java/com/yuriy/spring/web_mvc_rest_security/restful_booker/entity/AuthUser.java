package com.yuriy.spring.web_mvc_rest_security.restful_booker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class AuthUser {

    private String username;
    private String password;

    public AuthUser(boolean is) {
        this.username = "admin";
        this.password = "password123";

    }

    public AuthUser() {
    }
}

