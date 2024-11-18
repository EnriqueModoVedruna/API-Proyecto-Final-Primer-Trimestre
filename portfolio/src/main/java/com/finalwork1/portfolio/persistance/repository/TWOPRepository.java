package com.finalwork1.portfolio.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalwork1.portfolio.persistance.model.DWOP;
import com.finalwork1.portfolio.persistance.model.DWOPID;


public interface TWOPRepository extends JpaRepository<DWOP, DWOPID>{
    
}
