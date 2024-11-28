package com.finalwork1.portfolio.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalwork1.portfolio.persistance.model.Developers;

@Repository
public interface DevelopersRepository extends JpaRepository<Developers, Integer>{
    // Los respositorios se quedan vacios porque los metodos que vamos a utilizar se crean automaticamente y no hace falta crearlos
    // manualmente, por lo que se quedan vacíos. Si, la mayoria de codigo comentado lo pongo en Developers a menos de que algun otro
    // objeto / modelo tenga algo nuevo, ya que en base son todos lo mismo
}
