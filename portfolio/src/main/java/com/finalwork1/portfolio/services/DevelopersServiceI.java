package com.finalwork1.portfolio.services;

import com.finalwork1.portfolio.dto.DevelopersDTO;

public interface DevelopersServiceI {
    // Cuando estaba haciendo los controladores me di cuenta de que cree un metodo que no era necesario, entonces simplemente lo dejé comentado
    // DevelopersDTO getDevelopers(Integer id);

    void deleteDevelopers(Integer id);

    DevelopersDTO createDevelopers(DevelopersDTO dto);

    DevelopersDTO addDevelopersToProject(Integer idDevelop, Integer idProj);
}
