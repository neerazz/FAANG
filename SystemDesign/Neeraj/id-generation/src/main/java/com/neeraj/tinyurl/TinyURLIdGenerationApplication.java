package com.neeraj.tinyurl;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
@EnableEurekaClient
public class TinyURLIdGenerationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinyURLIdGenerationApplication.class, args);
    }

}
