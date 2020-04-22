package com.example.trainerplanner.model.domain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
@Component
public class TrainerModel {
	//Malli Trainerille, lisää attribuutit, nimi, toistot, sarjat
	public String Trainer(@RequestParam(value="name")String name, Integer reps, Integer sets, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("reps", reps);
		model.addAttribute("sets", sets);
		
		return "index";
	}
	
	
}
