package com.sachi.micro.tinyurl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public @Data
class TinyURL {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String shortURL;
    private String longURL;
    private Long userId;
    private long hits;
    private Date createDate;
    private Date expiryDate;

}
