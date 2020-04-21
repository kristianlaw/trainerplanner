package com.example.trainerplanner.model.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//Repositorio Kategoriaan CRUD-ominaisuuksilla
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);
    
}
