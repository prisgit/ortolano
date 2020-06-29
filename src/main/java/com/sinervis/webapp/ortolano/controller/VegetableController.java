package com.sinervis.webapp.ortolano.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinervis.webapp.ortolano.model.Mese;
import com.sinervis.webapp.ortolano.model.Vegetable;
import com.sinervis.webapp.ortolano.repository.MeseRepositoryInterface;
import com.sinervis.webapp.ortolano.repository.VegetableRepositoryInterface;

@Controller
@RequestMapping(value="/ortolano")
public class VegetableController {
	
	@Autowired
	private VegetableRepositoryInterface vegetableRepository;
	
	@Autowired
	private MeseRepositoryInterface meseRepository;
	
	@GetMapping(value="/default")
	public String home() {
		return "redirect:/ortolano/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Vegetable> vegetables = new ArrayList<>();
		List<Mese> mesi = new ArrayList<>();
		vegetables = vegetableRepository.findAll();
		mesi = meseRepository.findAll();
		model.addAttribute("vegetables", vegetables);
		model.addAttribute("mesi", mesi);
		return "list";
	}

	@GetMapping(value="/insert")
	public String insert(Model model) {
		Vegetable vegEmpty = new Vegetable();
		List<Mese> mesi = new ArrayList<>();
		mesi = meseRepository.findAll();
		model.addAttribute("vegetable", vegEmpty);
		model.addAttribute("mesi", mesi);
		return "insert_update";
	}
	
	@PostMapping(value="/save")
	public String saveWithRequest(HttpServletRequest req) {
		String[] mesiSowing = req.getParameterValues("sowing");//mesiSowing: lista di stringhe con i nomi dei mesi di quell'ortaggio
        String[] mesiHarvest = req.getParameterValues("harvest");
        List<Mese> sowing = new ArrayList<>();//sowing: lista di oggetti "Mese" con un "idMese" ed un "nomeMese"
        List<Mese> harvest = new ArrayList<>();
        //devo fare in modo che la lista di oggetti "Mese" contenga i nomeMese che sono 
        //presenti nella lista di stringhe ed il corrispettivo idMese ("Gennaio", idMese=1; "Febbraio", idMese=2, ecc)
        for (int i=0; i< mesiSowing.length; i++) {
        	Mese mese = new Mese();
        	int idMese = mese.getIdMese(mesiSowing[i]);
        	mese.setIdMese(idMese);
        	mese.setNomeMese(mesiSowing[i]);
        	sowing.add(mese);
        }
        for (int i=0; i< mesiHarvest.length; i++) {
        	Mese mese = new Mese();
        	int idMese = mese.getIdMese(mesiHarvest[i]);
        	mese.setIdMese(idMese);
        	mese.setNomeMese(mesiHarvest[i]);
        	harvest.add(mese);
        }    
        Vegetable veg = new Vegetable();
        int id = Integer.parseInt(req.getParameter("id"));
        if (id != 0) {
        	veg.setId(id);
        }
        veg.setName(req.getParameter("name"));
        veg.setDescription(req.getParameter("description"));
        veg.setSun(Integer.parseInt(req.getParameter("sun")));
        veg.setWater(Integer.parseInt(req.getParameter("water")));
        veg.setSowing(sowing);
        veg.setHarvest(harvest);
        // salvo l'oggetto sul db
        vegetableRepository.save(veg); 
		return "redirect:/ortolano/list";
	}

	@GetMapping(value="/{id}/update")
	public String edit(@PathVariable int id, Model model) {
		Vegetable veg = new Vegetable();
		List<Mese> mesi = new ArrayList<>();
		veg = vegetableRepository.getOne(id);
		mesi = meseRepository.findAll();
		model.addAttribute("vegetable", veg);
		model.addAttribute("mesi", mesi);
		return "insert_update";
	}
	
	@GetMapping(value="/{id}/delete")
	public String deleteWithRequest(@PathVariable int id) {
		Vegetable veg = new Vegetable();
		veg = vegetableRepository.getOne(id);
		vegetableRepository.delete(veg);	
		return "redirect:/ortolano/list";
	}
}
