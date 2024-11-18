package com.finalwork1.portfolio.persistance.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "technologies")
@Entity
public class Technologies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tech_id", nullable= false)
    Integer id;
    
    @Column(name="tech_name", nullable = false)
    String nombreTecnologia;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="tecnologia")
    List<TUIP> tecnologias;
}
