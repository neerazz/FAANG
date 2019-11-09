package com.sachi.micro.tinyurl.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class ErrorDetails {
    private Date timestamp;
    private String details;
    private String message;
    private List<String> messages;
}
