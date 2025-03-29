package OnliX.TiendaOnline.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OnliX.TiendaOnline.model.order;

@Repository
public interface IOrder extends JpaRepository<order,Integer> {
/*
 * JpaRepository
 * SELECT
 * UPDATE
 * INSERT
 * DELETE
 * por defecto
 */
}
