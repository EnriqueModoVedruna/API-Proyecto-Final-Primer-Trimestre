package com.finalwork1.portfolio.persistance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

// Esta es la tabla mas sencilla, realmente solo contiene 2 campos, no hace falta que explique mas, porque no tiene relacion alguna
// Con otra tabla, ni nada raro / complejo

// Además, no le hace falta un dto porque no se pueden crear más status, ni tampoco se pueden editar, asi que solo se crea el objeto para que se puedan asignar valores.
@Entity
@Table(name="status")
@Data
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="status_id", nullable= false)
    Integer id;

    @Column(name="status_name", nullable = false)
    String nombreStatus;

}
