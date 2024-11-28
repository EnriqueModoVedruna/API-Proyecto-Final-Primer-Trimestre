package com.finalwork1.portfolio.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalwork1.portfolio.persistance.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{
    
}
