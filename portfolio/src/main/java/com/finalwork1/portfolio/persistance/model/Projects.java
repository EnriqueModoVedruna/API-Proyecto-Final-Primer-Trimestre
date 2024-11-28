package com.finalwork1.portfolio.persistance.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    // String... Este string lo dejé comentado porque previamente usaba el campo String para definir las fechas
    // pero vi mas adecuado utilizar el LocalDate
    LocalDate fechaInicio;

    @Column(name="end_date")
    LocalDate fechaFin;

    @Column(name="repository_url", nullable = false)
    String urlRepositorio;

    @Column(name="demo_url", nullable = false)
    String urlDemo;

    @Column(name="picture")
    String foto;

    @Column(name="status_status_id", nullable = false)
    Integer statusId;

    @ManyToMany(mappedBy="proyectosDesarrolladores") // Indicamos en la relacion ManyToMany el nombre de la lista Proyectos que creamos en la Tabla Developers
    List<Developers> proyectosDWOP;
    
    @ManyToMany(mappedBy="proyectosTecnologias") // Lo mismo, pero esta vez en la tabla Technologies
    List<Technologies> proyectosTUIP;
}
