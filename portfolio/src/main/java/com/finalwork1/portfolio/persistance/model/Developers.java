package com.finalwork1.portfolio.persistance.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "developers") // Hacemos relacion con la tabla developers
@Data // Importamos Lombok
@NoArgsConstructor // Creamos los constructores sin argumento
public class Developers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dev_id", nullable= false)
    Integer id; // Generamos el campo ID, decimos que autogenere este campo, lo relacionamos con la tabla y utilizamos Integer

    @Column(name="dev_name", nullable = false)
    String nombre;

    @Column(name="dev_surname", nullable = false)
    String apellido;

    @Column(name="email", nullable = false)
    String email;

    @Column(name="linkedin_url")
    String linkedinUrl;

    @Column(name="github_url")
    String githubUrl;

    @ManyToMany(fetch= FetchType.LAZY) // Hacemos la relacion ManyToMany, indicando la tabla intermedia
    @JoinTable(
        name = "developers_worked_on_projects", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "developers_dev_id"), // Columna de esta entidad en la tabla intermedia
        inverseJoinColumns = @JoinColumn(name = "projects_project_id") // Columna de la otra entidad en la tabla intermedia
    )
    List<Projects> proyectosDesarrolladores;

}
