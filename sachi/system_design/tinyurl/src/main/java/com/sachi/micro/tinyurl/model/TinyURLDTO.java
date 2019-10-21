package com.sachi.micro.tinyurl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Date createDate;
    private Date expiryDate;
    @NotBlank
    private String apiKey;
}
