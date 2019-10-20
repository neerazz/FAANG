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
    private List<String> message;
    private String details;
}
