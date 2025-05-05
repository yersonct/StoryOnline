package OnliX.TiendaOnline.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import OnliX.TiendaOnline.model.discount;

@Repository
public interface IDiscount extends JpaRepository<discount,Integer> {
/*
 * JpaRepository
 * SELECT
 * UPDATE
 * INSERT
 * DELETE
 * por defecto
 */



//  @Query("SELECT u FROM Users u WHERE u.name LIKE %?1%")
// List<Users> findByName(String name);
//  @Query("SELECT u FROM discount u WHERE u.code LIKE %?1%")
//  List<discount> findByName(String code);
 
}
