package com.neeraj.tinyurl.model.entity;

import com.neeraj.tinyurl.model.UsagePlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class UserDetailsEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "USER_NAME", unique = true, nullable = false)
    private String userID;
    private String accessToken;

    private UsagePlan usagePlan;

    private Integer noOfRequestsPerDay;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_NAME", referencedColumnName = "USER_NAME")
    private List<UserDetailsAccessedEntity> lastAccessed;

}
