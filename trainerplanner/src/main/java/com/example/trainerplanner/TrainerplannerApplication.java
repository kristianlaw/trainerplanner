package com.example.trainerplanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.trainerplanner.model.domain.Trainer;
import com.example.trainerplanner.model.domain.TrainerRepository;
import com.example.trainerplanner.model.domain.Category;
//Skannaa komponentit paketista
@ComponentScan({"com.example.trainerplanner.model.domain", "com.example.trainerplanner.trainerController", "com.example.trainerplanner.model"})
@EnableAutoConfiguration
@SpringBootApplication


public class TrainerplannerApplication {
	private static final Logger log = LoggerFactory.getLogger(TrainerplannerApplication.class);
	//Starttaa applikaation
	public static void main(String[] args) {
		SpringApplication.run(TrainerplannerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner trainerDemo(CategoryRepository crepository, TrainerRepository trepository) {
		return (args) -> {
			log.info("Save some exercises");
			//Tässä kohdassa tehdään uudet kategoriat "c repositoryyn".
			//Ensiksi on yläkropan päälihakset ja sitten alakropan 
			
			crepository.save(new Category("Biceps")); //Hauikset
			crepository.save(new Category("Triceps")); //Ojentajat
			crepository.save(new Category("Chest")); //Rinta
			crepository.save(new Category("Shoulders")); //Olkapäät
			crepository.save(new Category("Back")); //Selkä
			
			crepository.save(new Category("Quadriceps")); //Etureidet
			crepository.save(new Category("Hamstrings")); //Takareidet
			crepository.save(new Category("Calves")); //Pohkeet
			crepository.save(new Category("Glutes")); //Pakarat
			//Tallennetaan ns. "profiileja" t repositorioon. Nimi, toistot, sarjat ja lisätään kategoria c repositoriosta.
			trepository.save(new Trainer("Bicep curl", 8, 3, crepository.findByName("Biceps").get(0)));
			trepository.save(new Trainer("Tricep extension", 8, 3, crepository.findByName("Triceps").get(0)));
			trepository.save(new Trainer("Squat", 8, 3, crepository.findByName("Quadriceps").get(0)));
		
	
				
		log.info("fetch all exercises");
			for (Trainer trainer : trepository.findAll()) {
			log.info(trainer.toString());
	
	};
	};}
	
	}

	
	

