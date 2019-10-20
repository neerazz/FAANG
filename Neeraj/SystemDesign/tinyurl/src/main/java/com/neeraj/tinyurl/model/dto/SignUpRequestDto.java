package com.neeraj.tinyurl.model.dto;

import com.neeraj.tinyurl.model.UsagePlan;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class SignUpRequestDto {

    @NotNull(message = "User ID Field cannot be null")
    @Size(max = 10, message = "User ID can only have maximum of 10 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9.]{0,20}$", message = "Characters a-z, numbers, dot(.) are only valid.")
    private String userID;

    private UsagePlan usagePlan;
}
