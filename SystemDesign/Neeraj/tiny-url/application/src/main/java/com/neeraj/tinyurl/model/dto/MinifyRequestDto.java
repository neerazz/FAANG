package com.neeraj.tinyurl.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MinifyRequestDto {

    @NotNull(message = "User ID Field cannot be null")
    @Size(max = 10, message = "User ID can only have maximum of 10 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9.]{0,20}$", message = "Characters a-z, numbers, dot(.) are only valid.")
    @ApiModelProperty(name = "This must be the user ID of the person creating the short URL.", example = "abc123")
    private String userId;

    @NotNull(message = "Long URL Field cannot be null")
    @Pattern(regexp = "\\b((http|https):\\/\\/?)[^\\s()<>]+(?:\\([\\w\\d]+\\)|([^[:punct:]\\s]|\\/?))",
            message = "Allowed characters are Characters a-z, numbers, dot(.), semicolon(:), question(?) are only.")
    @ApiModelProperty(name = "This is the long URL that you want to shorten.",
            example = "https://www.educative.io/collection/page/5668639101419520/5649050225344512/5668600916475904/")
    private String longURL;

    @Size(max = 20)
    @Pattern(regexp = "^[a-zA-Z/0-9?.]{0,20}$",
            message = "Allowed characters are Characters a-z, numbers, dot(.), semicolon(:), question(?) are only.")
    private String shortURL;
}
