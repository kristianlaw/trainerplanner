package com.example.trainerplanner.model.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
//Repositorio käyttäjälle CRUD-ominaisuuksilla
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}