package com.finalwork1.portfolio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalwork1.portfolio.dto.CreateProjectsDTO;
import com.finalwork1.portfolio.dto.ProjectsDTO;
import com.finalwork1.portfolio.persistance.model.Projects;
import com.finalwork1.portfolio.persistance.repository.ProjectsRepository;

@Service
public class ProjectsServiceImpl implements ProjectsServiceI {
    @Autowired
    private ProjectsRepository proRepo;
    
    // Servicio para mostrar todos los Proyectos
    @Override
    public List <ProjectsDTO> getAllProjects() {
        return proRepo.findAll()
                                .stream()
                                .map(ProjectsDTO::new) // Este For each añade todos los datos de los proyectos a un nuevo DTO
                                .collect(Collectors.toList()); // Mete los datos en una lista y los muestra
    }

    @Override //Servicio para buscar un proyecto por nombre / que contengan x letras
    public List<ProjectsDTO> getProjects(String a) {
        return proRepo.findByNombreProyectoContaining(a) // Es similar al anterior, pero este utiliza el find by Nombre seguido del Containing, el cual nos permite buscar todos los proyectos cuyo nombre contenga X letras o palabras, numeros... Que le pasemos como parametro y sean similares
                                .stream()
                                .map(ProjectsDTO::new)
                                .collect(Collectors.toList());
    }

    @Override
    public ProjectsDTO createProjects(CreateProjectsDTO dto) {
        Projects pro = new Projects();
        pro.setId(0);
        pro.setNombreProyecto(dto.getNombre());
        pro.setDescripcion(dto.getDescripcion());
        pro.setFechaInicio(dto.getFechaInicio());
        pro.setFechaFin(dto.getFechaFin());
        pro.setUrlRepositorio(dto.getUrlRepositorio());
        pro.setUrlDemo(dto.getUrlDemo());
        pro.setFoto(dto.getFoto());
        pro.setStatusId(dto.getStatusId());
        return new ProjectsDTO(proRepo.save(pro));
    }

    @Override
    public ProjectsDTO editProjects(CreateProjectsDTO dto, Integer id) {
        // Antes de nada, creo un condicional que busca el id y si no lo encuentra da un error, ya que si no
        // crearia un nuevo objeto destruyendo al antiguo, cuando lo que buscamos es editar.
        if(proRepo.findById(id).orElse(null) == null) {
            throw new NullPointerException();
        }
        
        Projects pro = new Projects();
        pro.setId(id);
        pro.setNombreProyecto(dto.getNombre());
        pro.setDescripcion(dto.getDescripcion());
        pro.setFechaInicio(dto.getFechaInicio());
        pro.setFechaFin(dto.getFechaFin());
        pro.setUrlRepositorio(dto.getUrlRepositorio());
        pro.setUrlDemo(dto.getUrlDemo());
        pro.setFoto(dto.getFoto());
        pro.setStatusId(dto.getStatusId());
        return new ProjectsDTO(proRepo.save(pro));
    }
}
