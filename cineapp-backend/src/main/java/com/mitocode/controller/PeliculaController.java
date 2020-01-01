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

import com.mitocode.model.Pelicula;
import com.mitocode.service.IPeliculaService;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

	@Autowired
	private IPeliculaService service;
	
	@GetMapping
	public List<Pelicula> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Pelicula listarPorId(@PathVariable("id") Integer id){
		return service.listarPorId(id);
	}
	
	@PostMapping
	public Pelicula registrar(@RequestBody Pelicula pel) {
		return service.registrar(pel);
	}
	
	@PutMapping
	public Pelicula modificar(@RequestBody Pelicula pel) {
		return service.modificar(pel);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}
}
