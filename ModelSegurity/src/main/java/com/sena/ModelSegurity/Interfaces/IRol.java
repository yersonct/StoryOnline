package com.sena.ModelSegurity.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.ModelSegurity.Model.Rol;

@Repository
public interface IRol extends JpaRepository<Rol, Integer> {
    // JpaRepository
    // SELECT
    // UPDATE
    // INSERT
    // DELETE
    // por defecto
    // No es necesario implementar los métodos de JpaRepository, ya que se generan automáticamente.

}
