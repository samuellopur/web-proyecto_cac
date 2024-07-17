package com.apiTren.crudJava.controllers;

import com.apiTren.crudJava.models.UsersModel;
import com.apiTren.crudJava.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@AllArgsConstructor()
@RestController
@RequestMapping("/proyecto_cac")
public class UserController {
    //definimos las peticiones htttp y las rutas
    // esto cuando ya se han creado los servicios

    //injectamos dependencias

    private final UserService userService;

    //METODO PARA CONSULTA DE TODA LA INFORMACION
    @GetMapping
    public ArrayList<UsersModel> getUsers() {
        return  this.userService.getUsers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UsersModel saveUser(@RequestBody UsersModel user){
        return this.userService.saveUser(user);
    }

    //METODO PARA CONSULTA POR ID
    @GetMapping(path = "/{id}")
    public Optional<UsersModel> getUserById(@PathVariable Long id) {
        return this.userService.getById(id);
    }

    //METODO PARA UPDATE
    @PutMapping(path = "/{id}")
    public UsersModel updateUserById(@RequestBody UsersModel request, @PathVariable("id") Long id) {
        return this.userService.updateById(request, id);
    }

    //METOOD PARA DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);
        if(ok) {
            return "User con el ID " + id + " ha sido eleiminado";
        } else{
            return "User con el ID " + id + " no ha sido eleiminado  ERROR!!!!";
        }
    }


}
