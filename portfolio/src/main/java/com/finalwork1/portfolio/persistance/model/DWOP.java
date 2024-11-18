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
@Table(name="developers_worked_on_projects")
@Data
@NoArgsConstructor
public class DWOP {

    @EmbeddedId
    private DWOPID id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="developers_dev_id", referencedColumnName="dev_id")
    Developers desarrollador;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="projects_project_id", referencedColumnName="project_id")
    Projects proyecto;

}
