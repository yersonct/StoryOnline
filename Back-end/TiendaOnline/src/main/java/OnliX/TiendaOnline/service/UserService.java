package OnliX.TiendaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnliX.TiendaOnline.DTO.requestRegisterUser;
import OnliX.TiendaOnline.Interfaces.IUser;
import OnliX.TiendaOnline.model.Users;


@Service
public class UserService {

    /*
     * @Autowired = Incluye la conexion de la interface
     */
    @Autowired
    private  IUser UserData;
    public List<Users> findAllUSer(){
        return UserData.findAll(); // obtener todos los usuario 
    }

    public Optional<Users> findByIdUser(int id){
        return UserData.findById(id);
    }

    public void save(Users user){
        UserData.save(user);
    }

   


    public List<Users> findByName(String name){
        return UserData.findByName(name);
    }
    public void update(int id,requestRegisterUser userUpdate){
        var user = findByIdUser(id);
        if(user.isPresent()){
            user.get().setName(userUpdate.getName());
            user.get().setEmail(userUpdate.getEmail());
            user.get().setRole(userUpdate.getRole());
            
            UserData.save(user.get());
        }
    }
    public void Delete(int id){
        var user =  findByIdUser(id);
        if(user.isPresent()){
            UserData.delete(user.get());
        }
    }
}
