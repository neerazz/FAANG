package com.sachi.micro.tinyurl.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public @Data
class UsersDTO {

    private long userId;
    private String apiKey;
    private Date userCreateDate;
    @NotBlank(message = "FirstName cannot be blank")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank")
    private String lastName;
    @NotBlank(message = "Email address cannot be blank")
    @Email
    private String email;
}
