package com.example.trainerplanner;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.trainerplanner.model.domain.Category;

@Repository
//Repositorio Kategoriaan CRUD-ominaisuuksilla
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);
    
}
