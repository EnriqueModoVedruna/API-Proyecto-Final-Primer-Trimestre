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

import com.finalwork1.portfolio.dto.DevelopersDTO;
import com.finalwork1.portfolio.services.DevelopersServiceI;

@RestController
@RequestMapping("/developers")
@CrossOrigin
public class DevelopersController {
    
    @Autowired
    DevelopersServiceI devServ; // Para poder utilizar el servicio tenemos que importar las interfaces

    @DeleteMapping("/{id}")
    public ResponseEntity <String> deleteById(@PathVariable Integer id) {
        try{ // Implementamos el try catch para que no nos de error si no encuentra el ID
            devServ.deleteDevelopers(id); // Como en todos los servicios, solo tenemos que llamar al metodo X y pasarle los parametros que requiera ese metodo para funcionar
            return ResponseEntity.ok("Desarrollador borrado"); // Este metodo como es string podemos devolver un texto
        }catch (Exception e){
            //Si no encuentra el ID, lanza un 404 y sigue funcionando
            return ResponseEntity.notFound().build();
        }
        
    }

    @PostMapping()
    public ResponseEntity <DevelopersDTO> create(@RequestBody DevelopersDTO dto){
        try{
            return ResponseEntity.ok(devServ.createDevelopers(dto)); // Como en los demas metodos nos pide un objeto a devolver, hay que devolver un objeto
        }catch (Exception e){
            //Si intentamos crear un Desarrollador y uno de los campos es incompatible, nos da error
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{idDeveloper}/worked/{idProject}")
    public ResponseEntity <DevelopersDTO> addToProject(@PathVariable Integer idDeveloper, @PathVariable Integer idProject){ // Para usar este metodo debemos introducir 2 id, el del desarrollador a añadir y el del proyecto 
        try {
            return ResponseEntity.ok(devServ.addDevelopersToProject(idDeveloper, idProject));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // El servicio descartado de buscar el Desarrollador por ID
    // @GetMapping("/{id}")
    // public ResponseEntity <DevelopersDTO> getById(@PathVariable Integer id) {
    //     try{
    //         return ResponseEntity.ok(devServ.getDevelopers(id));
    //     }catch (Exception e){
    //         //Si no encuentra el ID, lanza un 404 y sigue funcionando
    //         return ResponseEntity.notFound().build();
    //     }
        
    // }
}
