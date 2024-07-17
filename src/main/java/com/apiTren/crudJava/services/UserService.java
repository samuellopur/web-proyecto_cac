package com.apiTren.crudJava.services;

import com.apiTren.crudJava.models.UsersModel;
import com.apiTren.crudJava.repositories.IdUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@AllArgsConstructor()
@Service
// En el servicio se crea los métodos a utilizar en el controlador
//se llama al repo para poder conectar con la base de datos
public class UserService {

    //Injeccion de dependencias
    private final IdUserRepository userRepository;

    /*Método que viene jparepository trae métodos como findall para buscar todos los datos y mostrarlos
    a traves del array list*/
    public ArrayList<UsersModel> getUsers() {
        return (ArrayList<UsersModel>) userRepository.findAll();
    }

    //guardamos los ususarios
    public UsersModel saveUser(UsersModel user) {
//        user.setCreatedDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    //OPTIONAL puede devolver algo especifico o null
    public Optional<UsersModel> getById(Long id) {
        return userRepository.findById(id);
    }

    public UsersModel updateById(UsersModel request, Long id){
        UsersModel user = userRepository.findById(id).get();

        //seteamos
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        //Se actualiza y guarda cambios
        userRepository.save(user);

        return user;
    }

    //boleano valida si se ha borrado el registro
    public Boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
