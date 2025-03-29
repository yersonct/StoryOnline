package OnliX.TiendaOnline.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
}
