package com.neeraj.tinyurl.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TinyURLEntity {

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
