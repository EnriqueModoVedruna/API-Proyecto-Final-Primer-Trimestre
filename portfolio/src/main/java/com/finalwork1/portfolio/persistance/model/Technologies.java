package com.finalwork1.portfolio.persistance.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany // Similar que en developers, creamos una relacion ManyToMany pero cambiando ligeramente algunas cosas para referirnos a otra tabla intermedia.
    @JoinTable(
        name = "technologies_used_in_projects", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "technologies_tech_id"), // Columna de esta entidad en la tabla intermedia
        inverseJoinColumns = @JoinColumn(name = "projects_project_id") // Columna de la otra entidad en la tabla intermedia
    )
    List<Projects> proyectosTecnologias;
}
