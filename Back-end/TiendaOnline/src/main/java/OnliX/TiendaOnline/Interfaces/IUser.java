package OnliX.TiendaOnline.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import OnliX.TiendaOnline.model.user;
@Repository
public interface IUser extends JpaRepository<user,Integer>{
/*
 * JpaRepository
 * SELECT
 * UPDATE
 * INSERT
 * DELETE
 * por defecto
 */
} 
    

