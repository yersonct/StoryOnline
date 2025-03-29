package OnliX.TiendaOnline.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OnliX.TiendaOnline.model.cart;

@Repository
public interface ICart extends JpaRepository<cart,Integer> {

}
