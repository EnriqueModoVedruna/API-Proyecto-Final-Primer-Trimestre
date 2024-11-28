package com.finalwork1.portfolio.services;

import com.finalwork1.portfolio.dto.TechnologiesDTO;

public interface TechnologiesServiceI {
    // Servicio descartado de obtener la tecnologia por el ID, porque sobraba
    // Technologies getTechnologies(Integer id);

    void deleteTechnologies(Integer id);

    TechnologiesDTO createTechnologies(TechnologiesDTO dto);

    TechnologiesDTO addTechnologieToProject(Integer idTecnologia, Integer idProyecto);
}
