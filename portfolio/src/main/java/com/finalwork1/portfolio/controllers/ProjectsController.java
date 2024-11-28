package com.finalwork1.portfolio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalwork1.portfolio.dto.CreateProjectsDTO;
import com.finalwork1.portfolio.dto.ProjectsDTO;
import com.finalwork1.portfolio.services.ProjectsServiceI;

@RestController
@RequestMapping("/projects")
@CrossOrigin
public class ProjectsController {
    
    @Autowired
    ProjectsServiceI proServ;

    @PostMapping()
    public ResponseEntity <ProjectsDTO> create(@RequestBody CreateProjectsDTO dto){
        try{
            // dto.setId(0); Antes, para la creacion de un proyecto se le asignaba un id, pero luego vimos que con el autoincremento no hacia falta
            // ademas que quitando el campo ID damos mayor orden y seguridad.
            return ResponseEntity.ok(proServ.createProjects(dto));
        }catch (Exception e){
            //Si intentamos crear un Proyecto y uno de los campos es incompatible, nos da error
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <ProjectsDTO> edit(@RequestBody CreateProjectsDTO dto, @PathVariable Integer id){
        try{
            return ResponseEntity.ok(proServ.editProjects(dto, id));
        }catch (Exception e){
            //Si intentamos crear un Proyecto y uno de los campos es incompatible, nos da error
            return ResponseEntity.badRequest().build();
        }
    }

    // Controlador para buscar un proyecto por nombre
    @GetMapping("/{word}")
    public ResponseEntity <List<ProjectsDTO>> getProjects(@PathVariable String word) {
        try{
            return ResponseEntity.ok(proServ.getProjects(word));
        }catch (Exception e){
            //Si no encuentra el proyecto, lanza un 404 y sigue funcionando
            return ResponseEntity.notFound().build();
        }
    }

    // Controlador para mostrar todos los proyectos
    @GetMapping
    public ResponseEntity <List<ProjectsDTO>> getAllProjects() {
        try{
            return ResponseEntity.ok(proServ.getAllProjects());
        }catch (Exception e){
            //Si no encuentra ningun proyecto, lanza un 404 y sigue funcionando
            return ResponseEntity.notFound().build();
        }
    }
}
