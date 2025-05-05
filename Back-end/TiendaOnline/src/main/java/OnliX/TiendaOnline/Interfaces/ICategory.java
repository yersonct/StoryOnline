package OnliX.TiendaOnline.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import OnliX.TiendaOnline.model.Users;
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



 @Query("SELECT u FROM category u WHERE u.name LIKE %?1%")
 List<category> findByName(String name);
 
}
