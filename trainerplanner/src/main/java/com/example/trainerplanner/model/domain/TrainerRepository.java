package com.example.trainerplanner.model.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Long> {
	List<Trainer> findByLastName(String name);

	
}
