package com.finalwork1.portfolio.services;

import java.util.List;

import com.finalwork1.portfolio.dto.CreateProjectsDTO;
import com.finalwork1.portfolio.dto.ProjectsDTO;

public interface ProjectsServiceI {
    List<ProjectsDTO> getProjects(String a);

    List<ProjectsDTO> getAllProjects();

    ProjectsDTO createProjects(CreateProjectsDTO dto); //Metodo para crear Proyectos

    ProjectsDTO editProjects(CreateProjectsDTO dto, Integer id); //Metodo para editar Proyectos, el cual consta de el dto (los datos que le vamos a cambiar / nuevos datos) y el id del proyecto a editar


}
