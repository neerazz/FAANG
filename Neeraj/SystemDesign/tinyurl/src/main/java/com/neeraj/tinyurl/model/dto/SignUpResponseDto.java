package com.neeraj.tinyurl.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class SignUpResponseDto {

    @NotNull(message = "User ID Field cannot be null")
    @Size(max = 10, message = "User ID can only have maximum of 10 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9.]{0,20}$", message = "Characters a-z, numbers, dot(.) are only valid.")
    private String userID;

    private String accessToken;
    private Integer noOfRequestsPerDay;
}
