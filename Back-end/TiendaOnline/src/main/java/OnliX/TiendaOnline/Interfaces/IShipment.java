package OnliX.TiendaOnline.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import OnliX.TiendaOnline.model.Users;
import OnliX.TiendaOnline.model.shipment;

@Repository
public interface IShipment extends JpaRepository<shipment,Integer> {
/*
 * JpaRepository
 * SELECT
 * UPDATE
 * INSERT
 * DELETE
 * por defecto
 */
// @Query("SELECT u FROM Users u WHERE u.name LIKE %?1%")
// List<Users> findByName(String name);
// @Query("SELECT u FROM shipment u WHERE u.company_shippin LIKE %?1%")
// List<shipment> findByName(String company_shippin);
}
