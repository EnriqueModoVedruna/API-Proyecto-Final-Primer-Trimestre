package com.finalwork1.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalwork1.portfolio.dto.DevelopersDTO;
import com.finalwork1.portfolio.persistance.model.Developers;
import com.finalwork1.portfolio.persistance.model.Projects;
import com.finalwork1.portfolio.persistance.repository.DevelopersRepository;
import com.finalwork1.portfolio.persistance.repository.ProjectsRepository;

@Service
public class DevelopersServiceImpl implements DevelopersServiceI { // Para utilizar la interfaz, tenemos que implementarla
    @Autowired
    private DevelopersRepository devRepo;
    // Tambien tenemos que importar los Repositorios de Developers y Projects, para poder utilizar los metodos de creacion correspondientes
    @Autowired
    private ProjectsRepository proRepo;

    // Este es el metodo que no se usó al final, el de encontrar Desarrollador por ID
    // @Override
    // public DevelopersDTO getDevelopers(Integer id) {
    //     return new DevelopersDTO(devRepo.findById(id).get());
    // }

    @Override // Metodo para eliminar deasarrollador
    public void deleteDevelopers(Integer id) {
        Developers dev = devRepo.findById(id).orElse(null); // buscamos el desarrollador por el id que se nos ha proporcionado y si no está, entonces se queda en null y no se hace nada
        devRepo.delete(dev); // Como se encarga de eliminar, no tiene que devolver nada, por eso es void
    }

    @Override // Metodo para crear Desarrollador
    public DevelopersDTO createDevelopers(DevelopersDTO dto) { //Lo que hacemos es crear un nuevo objeto Desarrollador llamado dev.
        // En dev vamos a guardar los datos que le proporcionamos a traves de dto, que es la variable de entrada.
        Developers dev = new Developers();
        dev.setId(dto.getId());
        dev.setNombre(dto.getNombre());
        dev.setApellido(dto.getApellido());
        dev.setEmail(dto.getEmail());
        dev.setGithubUrl(dto.getGithubUrl());
        dev.setLinkedinUrl(dto.getLinkedinUrl());
        return new DevelopersDTO(devRepo.save(dev)); // Devolvemos el desarrollador que acabamos de crear, guardando los datos que le hemos insetado al objeto desarrollador como un nuevo desarrollador dentro de la base de datos.
    }

    @Override // Metodo para añadir a X desarrollador en Y proyecto
    public DevelopersDTO addDevelopersToProject(Integer idDevelop, Integer idProj){ //Recibimos el id del desarrollador y el id del proyecto
        Projects p = proRepo.findById(idProj).orElseThrow(); //Buscamos en la base de datos los id que correspondan con los que les hemos indicado, y si no los encuentra, pues que nos de error
        Developers d = devRepo.findById(idDevelop).orElseThrow();
        d.getProyectosDesarrolladores().add(p); //Anadimos el proyecto al desarrollador
        return new DevelopersDTO(devRepo.save(d)); // Y guardamos el desarrollador
    }
}
