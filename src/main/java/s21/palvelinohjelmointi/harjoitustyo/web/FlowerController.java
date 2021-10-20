package s21.palvelinohjelmointi.harjoitustyo.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import s21.palvelinohjelmointi.harjoitustyo.domain.FlowercategoryRepository;
import s21.palvelinohjelmointi.harjoitustyo.domain.Flower;
import s21.palvelinohjelmointi.harjoitustyo.domain.FlowerRepository;


//annotation controller makes this class communicate between model (domain)
//and view (html-templates) by listening to end points and passing attributes
@Controller
public class FlowerController {

	//injecting interfaces
	@Autowired
	private FlowerRepository repository;
	@Autowired
	private FlowercategoryRepository catrepository;
	
	
	//method listens to end point flowershop
	@GetMapping("/flowershop")
	//Model is used for adding attributes
	public String listFlowers(Model model) {
		
		//repository finds all instances from flower-table and
		//adds them to "flowers" attribute
		model.addAttribute("flowers", repository.findAll());
		return "flowershop";
	}
	
	
	//edit-button on the front page maps to this method, which renders the editFlower
	//template, and passes the object the user wants to edit to the template
	@GetMapping("/edit/{id}")
	public String editFlower(@PathVariable("id") Long flowerId, Model model) {
		
		Optional<Flower> flower = repository.findById(flowerId);
		model.addAttribute("flower", flower);
		
		model.addAttribute("categories", catrepository.findAll());
		return "editFlower";
	}
	
	
	//method saves the flower object edited in the editFlower form. If fields
	//have errors, it displays the form again with the error messages
	@PostMapping("/save/{id}")
	public String saveEditedFlower(@Valid Flower flower, Errors errors, Model model) {
		
		if (errors.hasErrors()) {
			model.addAttribute("categories", catrepository.findAll());
			return "editFlower";
		}
		 
		repository.save(flower);
		return "redirect:../flowershop";
	}
	
	//adding an empty flower object and rendering addFlower form when Add flower -button
	//is clicked
	@GetMapping("/add") 
	public String addFlower(Model model) {
		
		model.addAttribute("flower", new Flower());
		model.addAttribute("categories", catrepository.findAll());
		return "addFlower";
	}
	
	//method saves a new flower added in the addFlower form. If flower object is not
	//valid, it renders the addFlower template again
	@PostMapping("/save")
	public String saveFlower(@Valid Flower flower, Errors errors, Model model) {
		
		if (errors.hasErrors()) {
			model.addAttribute("categories", catrepository.findAll());
			return "addFlower";
		}
		 
		repository.save(flower);
		return "redirect:flowershop";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteFlower(@PathVariable("id") Long FlowerId, Model model) {
		
		repository.deleteById(FlowerId);
		return "redirect:../flowershop";
	}
	
}
