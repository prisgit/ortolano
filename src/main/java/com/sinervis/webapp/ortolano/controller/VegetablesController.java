package com.sinervis.webapp.ortolano.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinervis.webapp.ortolano.Vegetable;
import com.sinervis.webapp.ortolano.repository.VegetableRepositoryInterface;

@Controller
@RequestMapping(value="/ortolano")
public class VegetablesController {
	
	@Autowired
	//dice a Spring che dentro questa var ci metti un'istanza che implementa l'interfaccia
	private VegetableRepositoryInterface vegetableRepository;
	
	@GetMapping(value="/default")
	public String home() {
		return "redirect:/ortolano/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Vegetable> vegetables = new ArrayList<>();
		vegetables = vegetableRepository.findAll();
		model.addAttribute("vegetables", vegetables);
		return "list";
	}

	@GetMapping(value="/insert")
	public String insert(Model model) {
		Vegetable vegNull = new Vegetable();
		model.addAttribute("vegetable", vegNull);
		return "insert_update";
	}
		
	@GetMapping(value="/{id}/update")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("vegetable", vegetableRepository.getOne(id));
		return "insert_update";
	}
	
	@PostMapping(value="/save")
	public String save(@ModelAttribute Vegetable veg) {
		vegetableRepository.save(veg); 
		return "redirect:/ortolano/list";
	}

	@GetMapping(value="/delete")
	public String delete(@ModelAttribute Vegetable veg, Model model) {
		vegetableRepository.delete(veg);	
		return "redirect:/ortolano/list";
	}
	
}
