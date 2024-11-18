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
@Table(name = "developers")
@Data
@NoArgsConstructor
public class Developers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dev_id", nullable= false)
    Integer id;

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

    @OneToMany(fetch= FetchType.LAZY, mappedBy="desarrollador")
    List<DWOP> proyectos;

}
