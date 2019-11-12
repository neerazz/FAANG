package com.neeraj.tinyurl;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TinyURLIdGenerationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinyURLIdGenerationApplication.class, args);
    }

}
