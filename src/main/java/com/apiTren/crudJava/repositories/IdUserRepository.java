package com.apiTren.crudJava.repositories;

import com.apiTren.crudJava.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// un repositorio es una clase que  permite hacer consultas
@Repository
public interface IdUserRepository extends JpaRepository<UsersModel, Long> {

}
