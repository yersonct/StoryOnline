package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegisterUser;
import OnliX.TiendaOnline.Interfaces.IUser;
import OnliX.TiendaOnline.model.user;

@Service
public class UserService {

    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    private  IUser UserData;
    public List<user> findAllUSer(){
        return UserData.findAll(); // obtener todos los usuario 
    }

    public Optional<user> findByIdUser(int id){
        return UserData.findById(id);
    }

    public void save(requestRegisterUser user){
        UserData.save(convertRegisterToUser(user));
    }

    public user convertRegisterToUser(requestRegisterUser user){
      return new user(0, 
        user.getName(),
        user.getEmail(),
        null,
        null,
        null,
        user.getRole()
        );
    }
    public void update(int id,user userUpdate){
        var user = findByIdUser(id);
        if(user.isPresent()){
            user.get().setName(userUpdate.getName());
            user.get().setEmail(userUpdate.getEmail());
            user.get().setRole(userUpdate.getRole());
        }
    }
    public void Delete(int id){
        var user =  findByIdUser(id);
        if(user.isPresent()){
            UserData.delete(user.get());
        }
    }
}
