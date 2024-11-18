package com.finalwork1.portfolio.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalwork1.portfolio.persistance.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer>{
    
}
