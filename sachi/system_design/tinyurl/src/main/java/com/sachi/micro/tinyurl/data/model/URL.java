package com.sachi.micro.tinyurl.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@RequiredArgsConstructor
@AllArgsConstructor
public @Data
class URL {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String shortURL;
    private String longURL;
}
