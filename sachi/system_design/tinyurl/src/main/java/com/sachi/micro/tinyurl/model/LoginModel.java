package com.sachi.micro.tinyurl.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder
public @Data
class LoginModel {

    @NotBlank(message = "User Name cannot be blank")
    private String userName;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    private String token;
}
