package com.finalwork1.portfolio.dto;

import com.finalwork1.portfolio.persistance.model.Technologies;

import lombok.Data;
import lombok.NoArgsConstructor;

// Al ser el mas sencillo de todos, solo cuenta con estos 2 campos
@Data
@NoArgsConstructor
public class TechnologiesDTO {
    Integer id;
    String nombre;

    public TechnologiesDTO(Technologies tecnologia) {
        this.id = tecnologia.getId();
        this.nombre = tecnologia.getNombreTecnologia();
    }
}
