package com.jobtrackingapp.jobtrackingapp.repository;

import com.jobtrackingapp.jobtrackingapp.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
