package com.jobtrackingapp.jobtrackingapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appId;
    private Date appDate;
    private Boolean followUp;
    private Integer numberOfFollowUps;
    private String company;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
