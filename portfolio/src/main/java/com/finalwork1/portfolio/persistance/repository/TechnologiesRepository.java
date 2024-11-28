package com.finalwork1.portfolio.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalwork1.portfolio.persistance.model.Technologies;

@Repository
public interface TechnologiesRepository extends JpaRepository<Technologies, Integer>{
    
}
