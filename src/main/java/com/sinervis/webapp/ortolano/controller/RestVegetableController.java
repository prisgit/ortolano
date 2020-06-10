package com.sinervis.webapp.ortolano.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinervis.webapp.ortolano.model.Vegetable;
import com.sinervis.webapp.ortolano.repository.MeseRepositoryInterface;
import com.sinervis.webapp.ortolano.repository.VegetableRepositoryInterface;

@RestController
@RequestMapping(value="/api/v1/ortolano", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class RestVegetableController {
	
	@Autowired
	private VegetableRepositoryInterface vegetableRepository;
	
	@Autowired
	private MeseRepositoryInterface meseRepository;
		
//	@GetMapping(value="/list")
//	public @ResponseBody List<Vegetable> list() {
//		List<Vegetable> vegetables = new ArrayList<>();
//		vegetables = vegetableRepository.findAll();
//		return vegetables;
//	}

	@GetMapping(value="/list")
	public List<Vegetable> list() {
		List<Vegetable> vegetables = new ArrayList<>();
		vegetables = vegetableRepository.findAll();
		return vegetables;
	}
	
	@GetMapping(value="/{id}/get")
	public Vegetable getOne(@PathVariable int id) {
		return vegetableRepository.getOne(id);
	}
		
	@PutMapping("/save")
	@PostMapping("/save")
	public ResponseEntity<Vegetable> save(@RequestBody Vegetable veg) {
		vegetableRepository.save(veg); 
		return ResponseEntity.ok(veg);
	}

//	@DeleteMapping("/save")
	@RequestMapping(value="/save", method=RequestMethod.DELETE)
	public ResponseEntity<Vegetable> delete(@RequestBody Vegetable veg) {
		vegetableRepository.delete(veg);	
		return ResponseEntity.ok(veg);
	}
	
}
