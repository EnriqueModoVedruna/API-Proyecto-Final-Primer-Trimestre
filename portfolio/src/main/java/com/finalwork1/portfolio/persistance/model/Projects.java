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

@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
public class Projects {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="project_id", nullable = false)
    Integer id;

    @Column(name="project_name", nullable = false)
    String nombreProyecto;

    @Column(name="description")
    String descripcion;

    @Column(name="start_date", nullable = false)
    String fechaInicio;

    @Column(name="end_date")
    String fechaFin;

    @Column(name="repository_url", nullable = false)
    String urlRepositorio;

    @Column(name="demo_url", nullable = false)
    String urlDemo;

    @Column(name="picture")
    String foto;

    @Column(name="status_status_id", nullable = false)
    String statusId;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="proyecto")
    List<DWOP> proyectosDWOP;
    
    @OneToMany(fetch= FetchType.LAZY, mappedBy="proyecto")
    List<TUIP> proyectosTUIP;
}
