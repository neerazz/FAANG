package com.neeraj.tinyurl.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@EntityListeners(AuditingEntityListener.class)
public class IdEntity extends Auditable{

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String uniqueId;

    private LocalDateTime taken;

    @CreatedDate
    private LocalDateTime created;
//    TODO find out how the CreatedDate works.
}

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class Auditable {
    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date creationDate;
}