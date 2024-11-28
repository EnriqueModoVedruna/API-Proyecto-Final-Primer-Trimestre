package com.finalwork1.portfolio.dto;

import java.time.LocalDate;

import com.finalwork1.portfolio.persistance.model.Projects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Usamos Lombok
@NoArgsConstructor // E importamos los contructores vacíos
public class CreateProjectsDTO {
    // El dto utiliza los mismos campos que el objeto original, por ende hay que crear otra vez los mismos datos
    // No se crea el campo Integer porque no hace falta que el usuario le asigne un id al proyecto, ya que la propia base de datos se encarga de autoincrementar y asi no damos a posibles fallos.
    String nombre;
    String descripcion;
    LocalDate fechaInicio;
    LocalDate fechaFin;
    String urlRepositorio;
    String urlDemo;
    String foto;
    Integer statusId;

    public CreateProjectsDTO(Projects proyecto) { // Y luego añadir un metodo que nos permita asignarle los valores del objeto original al dto
        this.nombre = proyecto.getNombreProyecto();
        this.descripcion = proyecto.getDescripcion();
        this.fechaInicio = proyecto.getFechaInicio();
        this.fechaFin = proyecto.getFechaFin();
        this.urlRepositorio = proyecto.getUrlRepositorio();
        this.urlDemo = proyecto.getUrlDemo();
        this.foto = proyecto.getFoto();
        this.statusId = proyecto.getStatusId();
    }
}
