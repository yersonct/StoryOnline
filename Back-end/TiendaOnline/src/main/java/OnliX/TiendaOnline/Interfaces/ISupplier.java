package OnliX.TiendaOnline.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import OnliX.TiendaOnline.model.Users;
import OnliX.TiendaOnline.model.supplier;


@Repository
public interface ISupplier extends JpaRepository<supplier,Integer>{
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
    @Query("SELECT u FROM supplier u WHERE u.name LIKE %?1%")
    List<supplier> findByName(String name);
}
