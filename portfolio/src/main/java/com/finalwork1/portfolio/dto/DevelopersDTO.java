package com.finalwork1.portfolio.dto;

import com.finalwork1.portfolio.persistance.model.Developers;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DevelopersDTO {
    Integer id;
    String nombre;
    String apellido;
    String email;
    String linkedinUrl;
    String githubUrl;

    public DevelopersDTO(Developers desarrollador) {
        this.id = desarrollador.getId();
        this.nombre = desarrollador.getNombre();
        this.apellido = desarrollador.getApellido();
        this.email = desarrollador.getEmail();
        this.linkedinUrl = desarrollador.getLinkedinUrl();
        this.githubUrl = desarrollador.getGithubUrl();
    }
}
