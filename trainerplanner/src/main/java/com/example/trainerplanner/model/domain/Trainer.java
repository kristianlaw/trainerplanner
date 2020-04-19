package com.example.trainerplanner.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Component
@Entity
public class Trainer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private Integer reps, sets;
	
	@ManyToOne
    @JoinColumn(name = "categoryid")
    @JsonManagedReference

    private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Trainer() {
		//Empty
	}
	
	public Trainer(String name, Integer reps, Integer sets, Category category) {
		super();
		this.name = name;
		this.reps = reps;
		this.sets = sets;
		this.category =category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getReps() {
		return reps;
	}

	public void setReps(Integer reps) {
		this.reps = reps;
	}

	public Integer getSets() {
		return sets;
	}

	public void setSets(Integer sets) {
		this.sets = sets;
	}

	
	
	@Override
	public String toString() {
		if (this.category != null)
			return "Trainer [id=" + id + ", name=" + name + ", reps=" + reps + ", =" + sets + " sets =" + this.getCategory() + "]";		
		else
			return "Trainer [id=" + id + ", name=" + name + ", reps=" + reps + ", sets=" + sets + "]";
	}
	
	
}








