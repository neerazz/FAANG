package com.neeraj.tinyurl.model;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MinifyResponseDto {
    private String userId;
    private String longURL;
    private String shortURL;
    private LocalDateTime expiringOn;
}
