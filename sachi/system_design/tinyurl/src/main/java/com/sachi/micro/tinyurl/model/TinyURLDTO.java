package com.sachi.micro.tinyurl.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public @Data
class TinyURLDTO {

    private long id;
    @Max(16)
    private String shortURL;
    private String longURL;
    @NotBlank
    private String userId;
    private Date createDate;
    private Date expiryDate;
}
