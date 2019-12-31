package com.mitocode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Genero;
import com.mitocode.service.IGeneroService;

@RestController
@RequestMapping("/generos")
public class GeneroController {

	@Autowired
	private IGeneroService service;
	
	@GetMapping
	public List<Genero> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Genero listarPorId(@PathVariable("id") Integer id){
		return service.listarPorId(id);
	}
	
	@PostMapping
	public Genero registrar(@RequestBody Genero gen) {
		return service.registrar(gen);
	}
	
	@PutMapping
	public Genero modificar(@RequestBody Genero gen) {
		return service.modificar(gen);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}
}
