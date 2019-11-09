package com.sachi.micro.tinyurl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data
class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String apiKey;
    private Date userCreateDate;
    private String firstName;
    private String lastName;
    private String email;
}
