package OnliX.TiendaOnline.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import OnliX.TiendaOnline.model.Users;
import OnliX.TiendaOnline.model.product;

@Repository
public interface IProduct extends JpaRepository<product,Integer> {
/*
 * JpaRepository
 * SELECT
 * UPDATE
 * INSERT
 * DELETE
 * por defecto
 */
//     @Query("SELECT u FROM Users u WHERE u.name LIKE %?1%")
// List<Users> findByName(String name);
    @Query("SELECT u FROM product u WHERE u.name LIKE %?1%")
    List<product> findByName(String name);

}
