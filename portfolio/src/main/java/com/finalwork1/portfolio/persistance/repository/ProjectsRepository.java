package com.finalwork1.portfolio.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalwork1.portfolio.persistance.model.Projects;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Integer>{
    List<Projects> findByNombreProyectoContaining(String name);

    // Todas estas sineas tachadas eran metodos que se iban a encargar de obtener todos los Proyectos y Proyectos por nombre, pero
    // realmente 1 sobraba y el otro ya lo habia implementado arriba, lo dejo porque realmente esta chulo ver las ideas
    // descartadas de un proyecto.
    //    // List<Projects> getAllProjects();
        
    //    // List<Projects> getProjects(String projectName);
}
