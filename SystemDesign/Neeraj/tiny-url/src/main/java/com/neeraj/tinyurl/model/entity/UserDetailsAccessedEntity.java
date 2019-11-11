package com.neeraj.tinyurl.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailsAccessedEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date accessedDate;
    private Integer noOfTimesAccessed;
}
