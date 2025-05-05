package OnliX.TiendaOnline.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import OnliX.TiendaOnline.model.Users;
import OnliX.TiendaOnline.model.cart;

@Repository
public interface ICart extends JpaRepository<cart,Integer> {
/*
 * JpaRepository
 * SELECT
 * UPDATE
 * INSERT
 * DELETE
 * por defecto
 */


// @Query("SELECT u FROM cart u WHERE u.update_date LIKE %?1%")
// List<cart> findByName(String update_date);
}