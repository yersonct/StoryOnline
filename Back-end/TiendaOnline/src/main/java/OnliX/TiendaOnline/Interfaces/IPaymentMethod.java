package OnliX.TiendaOnline.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import OnliX.TiendaOnline.model.Users;
import OnliX.TiendaOnline.model.paymentMethod;

@Repository
public interface IPaymentMethod extends JpaRepository<paymentMethod,Integer> {
/*
 * JpaRepository
 * SELECT
 * UPDATE
 * INSERT
 * DELETE
 * por defecto
 */

    // @Query("SELECT u FROM paymentMethod u WHERE u.guy LIKE %?1%")
    // List<paymentMethod> findByName(String guy);
}
