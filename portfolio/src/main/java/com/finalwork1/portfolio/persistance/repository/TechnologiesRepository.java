package com.finalwork1.portfolio.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalwork1.portfolio.persistance.model.Technologies;

public interface TechnologiesRepository extends JpaRepository<Technologies, Integer>{
    
}
