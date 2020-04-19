package com.example.trainerplanner.trainerController;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainerplanner.model.domain.CategoryRepository;
import com.example.trainerplanner.model.domain.Trainer;
import com.example.trainerplanner.model.domain.TrainerRepository;

@RestController
public class TrainerController {
	
	
	public TrainerRepository trepository; 
	
	
	public CategoryRepository crepository;
	
    @RequestMapping(value= {"/", "/trainerlist"})
    public String trainerList(Model model) {	
        model.addAttribute("trainer", trepository.findAll());
        return "trainerlist";
    }
  
    @RequestMapping(value = "/add")
    public String addTrainer(Model model){
    	model.addAttribute("trainer", new Trainer());
    	model.addAttribute("category", crepository.findAll());
        return "addtrainer";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Trainer trainer){
        trepository.save(trainer);
        return "redirect:trainerlist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(@PathVariable("id") Long trainerId, Model model) {
    	trepository.deleteById(trainerId);
        return "redirect:../trainerlist";
    }     
}