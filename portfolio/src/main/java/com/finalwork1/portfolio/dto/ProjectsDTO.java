package com.finalwork1.portfolio.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.finalwork1.portfolio.persistance.model.Developers;
import com.finalwork1.portfolio.persistance.model.Projects;
import com.finalwork1.portfolio.persistance.model.Technologies;

import lombok.Data;
import lombok.NoArgsConstructor;

// Uso dos DTO, uno para crear proyectos y otro para editar proyectos / todo lo demás, porque aquí es donde creo las listas de desarrolladores y tecnologias
@Data
@NoArgsConstructor
public class ProjectsDTO {
    Integer project_id;
    String nombre;
    String descripcion;
    // String fechaInicio; Si, al igual que en el objeto base, aqui tambien iba a utilizar String, mientras iba avanzando en el proyecto
    // me decante por Localdate.
    LocalDate fechaInicio;
    LocalDate fechaFin;
    String urlRepositorio;
    String urlDemo;
    String foto;
    Integer statusId;

    List <DevelopersDTO> desarrolladores;
    List <TechnologiesDTO> tecnologias;

    public ProjectsDTO(Projects proyecto) {
        this.project_id = proyecto.getId();
        this.nombre = proyecto.getNombreProyecto();
        this.descripcion = proyecto.getDescripcion();
        this.fechaInicio = proyecto.getFechaInicio();
        this.fechaFin = proyecto.getFechaFin(); //.toString(); Cuando creamos ambos metodos get de las fechas, les pusimos para que los pasase a String, pero al final no hacia falta
        this.urlRepositorio = proyecto.getUrlRepositorio();
        this.urlDemo = proyecto.getUrlDemo();
        this.foto = proyecto.getFoto();
        this.statusId = proyecto.getStatusId();
        
        this.desarrolladores = new ArrayList<>(); // Con este metodo creamos una lista de desarrolladores para el proyecto que vayamos a crear
        if (proyecto.getProyectosDWOP() != null) {
            for (Developers dev : proyecto.getProyectosDWOP()) {
                this.desarrolladores.add (new DevelopersDTO(dev));
            }
        }
        

        this.tecnologias = new ArrayList<>(); // Lo mismo, pero para las tecnologias
        if (proyecto.getProyectosTUIP() != null) {
            for (Technologies tech : proyecto.getProyectosTUIP()) {
                this.tecnologias.add (new TechnologiesDTO(tech));
            }
        }
        
    }
}
