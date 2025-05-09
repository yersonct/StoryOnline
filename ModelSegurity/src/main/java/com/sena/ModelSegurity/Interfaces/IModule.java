package com.sena.ModelSegurity.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.ModelSegurity.Model.Module;
@Repository
public interface IModule extends JpaRepository<Module, Integer> {

    void save(java.lang.Module module);
    // JpaRepository
    // SELECT
    // UPDATE
    // INSERT
    // DELETE
    // por defecto
    // No es necesario implementar los métodos de JpaRepository, ya que se generan automáticamente.

}
