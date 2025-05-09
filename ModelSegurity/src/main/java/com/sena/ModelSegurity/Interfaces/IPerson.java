package com.sena.ModelSegurity.Interfaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.ModelSegurity.Model.Person;
@Repository
public interface IPerson extends JpaRepository<Person, Integer> {
   
/*
 * JpaRepository
 * SELECT
 * UPDATE
 * INSERT
 * DELETE
 * por defecto
 */
}
