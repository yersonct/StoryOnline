package OnliX.TiendaOnline.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OnliX.TiendaOnline.model.review;


@Repository
public interface IReview extends JpaRepository<review,Integer> {
/*
 * JpaRepository
 * SELECT
 * UPDATE
 * INSERT
 * DELETE
 * por defecto
 */
}
