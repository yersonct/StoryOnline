package OnliX.TiendaOnline.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import OnliX.TiendaOnline.model.Orders;
import OnliX.TiendaOnline.model.Users;

@Repository
public interface IOrder extends JpaRepository<Orders,Integer> {
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
//  @Query("SELECT u FROM Orders u WHERE u.date LIKE %?1%")
//  List<Orders> findByName(String name);
 
}
