package com.finalwork1.portfolio.persistance.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="technologies_used_in_projects")
@Data
@NoArgsConstructor
public class TUIP {

    @EmbeddedId
    private TUIPID id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="technologies_tech_id", referencedColumnName="tech_id")
    Technologies tecnologia;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="projects_project_id", referencedColumnName="project_id")
    Projects proyecto;
}
