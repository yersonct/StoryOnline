package com.sena.ModelSegurity.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.ModelSegurity.Model.Users;

@Repository
public interface IUsers extends JpaRepository<Users, Integer> {
    // JpaRepository
    // SELECT
    // UPDATE
    // INSERT
    // DELETE
    // por defecto

}
