package com.jobtrackingapp.jobtrackingapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
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
    private LocalDate appDate;
    private Date followUpDate;
    private Boolean followUp;
    private Integer numberOfFollowUps;
    private String company;
    private String jobTitle;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private enum status{
        APPLIED,
        FOLLOWED_UP,
        INTERVIEW,
        REJECTED,
        JOB_OFFER
    }
}
