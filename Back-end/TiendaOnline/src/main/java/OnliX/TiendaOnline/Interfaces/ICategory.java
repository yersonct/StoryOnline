package OnliX.TiendaOnline.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OnliX.TiendaOnline.model.category;

@Repository
public interface ICategory extends JpaRepository<category,Integer> {
/*
 * JpaRepository
 * SELECT
 * UPDATE
 * INSERT
 * DELETE
 * por defecto
 */
}
