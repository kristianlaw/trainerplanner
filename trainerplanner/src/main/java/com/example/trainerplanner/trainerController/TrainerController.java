package com.example.trainerplanner.trainerController;
import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainerplanner.model.domain.CategoryRepository;
import com.example.trainerplanner.model.domain.Trainer;
import com.example.trainerplanner.model.domain.TrainerRepository;
import com.example.trainerplanner.model.domain.User;

@Controller
@Component
@EnableJpaRepositories
public class TrainerController {
	
	@Autowired
	private TrainerRepository trepository; 
	
	@Autowired
	private CategoryRepository crepository;
		
	//Req. mappingeissä nähdään mikä menee urlin loppuun. esim. localhost:8080/trainerlist palauttaa trainerlist thymeleafsivun
    //Metodit eri toiminnoille, esim lisää, poista, lista, tallenna.
	@RequestMapping(value= {"/", "/trainerlist"})
    public String trainerList(Model model) {	
		model.addAttribute("trainers", trepository.findAll());
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
    //Poistaa ID:n avulla trainerin ja palauttaa //trainerlist-sivun
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(@PathVariable("id") Long trainerId, Model model) {
    	trepository.deleteById(trainerId);
        return "redirect:../trainerlist";
    }     
    //Login metodi joka sitten redirectaa käyttäjän trainerlistiin 
    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String login(User user) {
    	return "redirect:../trainerlist";
    }
    
}