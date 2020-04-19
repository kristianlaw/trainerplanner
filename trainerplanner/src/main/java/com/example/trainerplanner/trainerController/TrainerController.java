package com.example.trainerplanner.trainerController;
import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainerplanner.model.domain.CategoryRepository;
import com.example.trainerplanner.model.domain.Trainer;
import com.example.trainerplanner.model.domain.TrainerRepository;

@RestController
@Component
public class TrainerController {
	
	@Autowired
	private TrainerRepository trepository; 
	
	@Autowired
	private CategoryRepository crepository;
	
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