package com.finalwork1.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalwork1.portfolio.dto.TechnologiesDTO;
import com.finalwork1.portfolio.persistance.model.Projects;
import com.finalwork1.portfolio.persistance.model.Technologies;
import com.finalwork1.portfolio.persistance.repository.ProjectsRepository;
import com.finalwork1.portfolio.persistance.repository.TechnologiesRepository;

@Service //Como technoloies es el mas sencillo de todos realmente no hay nada destacable, primero hacia los otros repositorios y en base a ellos lo adapataba a technologies
public class TechnologiesServiceImpl implements TechnologiesServiceI{
    @Autowired
    private TechnologiesRepository techRepo;

    @Autowired
    private ProjectsRepository proRepo;

    @Override
    public void deleteTechnologies(Integer id) {
        Technologies dev = techRepo.findById(id).orElse(null);
        techRepo.delete(dev);
    }

    @Override
    public TechnologiesDTO createTechnologies(TechnologiesDTO dto){
        Technologies tech = new Technologies();
        tech.setId(dto.getId());
        tech.setNombreTecnologia(dto.getNombre());
        return new TechnologiesDTO(techRepo.save(tech));
    }

    @Override
    public TechnologiesDTO addTechnologieToProject(Integer t, Integer p){
        Projects pr = proRepo.findById(p).orElseThrow(); //Buscamos en la base de datos los id que correspondan con los que les hemos indicado, y si no los encuentra, pues que nos de error
        Technologies tec = techRepo.findById(t).orElseThrow();
        tec.getProyectosTecnologias().add(pr); //Anadimos la tecnologia al proyecto
        return new TechnologiesDTO(techRepo.save(tec)); // Y guardamos la tecnologia
    }

}
