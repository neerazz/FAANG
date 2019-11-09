package com.neeraj.tinyurl.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@RedisHash("TinyURLEntity")
public class TinyURLEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String userID;
    @Column(length = 2000)
    private String longURL;
    private String shortURL;
    private LocalDateTime createdAt;
    private LocalDateTime expiringOn;
    private Long noOfTimesAccessed;
}
