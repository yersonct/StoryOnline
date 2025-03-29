package OnliX.TiendaOnline.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OnliX.TiendaOnline.model.detailCart;

@Repository
public interface IDetailCart extends JpaRepository<detailCart,Integer> {
/*
 * JpaRepository
 * SELECT
 * UPDATE
 * INSERT
 * DELETE
 * por defecto
 */
}
