package com.finalwork1.portfolio.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalwork1.portfolio.persistance.model.TUIP;
import com.finalwork1.portfolio.persistance.model.TUIPID;

public interface TUIPRepository extends JpaRepository<TUIP, TUIPID>{
    
}
