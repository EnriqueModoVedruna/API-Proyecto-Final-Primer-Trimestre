package com.finalwork1.portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalwork1.portfolio.dto.TechnologiesDTO;
import com.finalwork1.portfolio.services.TechnologiesServiceI;

@RestController
@RequestMapping("/technologies")
@CrossOrigin
public class TechnologiesController {
    
    @Autowired
    TechnologiesServiceI techServ;
    
    @DeleteMapping("/{id}")
    public ResponseEntity <String> deleteById(@PathVariable Integer id) {
        try{
            techServ.deleteTechnologies(id);
            return ResponseEntity.ok("Tecnologia eliminada");
        }catch (Exception e){
            //Si no encuentra el ID, lanza un 404 y sigue funcionando
            return ResponseEntity.notFound().build();
        }
        
    }

    @PostMapping()
    public ResponseEntity <TechnologiesDTO> create(@RequestBody TechnologiesDTO dto){
        try{
            return ResponseEntity.ok(techServ.createTechnologies(dto));
        }catch (Exception e){
            //Si intentamos crear un Desarrollador y uno de los campos es incompatible, nos da error
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{idTechnologie}/techIn/{idProject}") //Volvemos a crear un metodo similar al de developers
    public ResponseEntity <TechnologiesDTO> addToProject(@PathVariable Integer idTechnologie, @PathVariable Integer idProject){ // Para usar este metodo debemos introducir 2 id, el del desarrollador a añadir y el del proyecto 
        try {
            return ResponseEntity.ok(techServ.addTechnologieToProject(idTechnologie, idProject));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
