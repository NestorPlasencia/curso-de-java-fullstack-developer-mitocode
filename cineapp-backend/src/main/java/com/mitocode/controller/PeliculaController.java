package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.model.Pelicula;
import com.mitocode.service.IPeliculaService;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

	@Autowired
	private IPeliculaService service;
	
	@GetMapping
	public ResponseEntity<List<Pelicula>> listar(){
		List<Pelicula> lista = service.listar();
		return new ResponseEntity<List<Pelicula>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pelicula> listarPorId(@PathVariable("id") Integer id){
		Pelicula obj = service.listarPorId(id);
		return new ResponseEntity<Pelicula>(obj, HttpStatus.OK);
	}
	
	/*@PostMapping
	public ResponseEntity<Pelicula> registrar(@RequestBody Pelicula obj) {
		Pelicula objeto = service.registrar(obj);
		return new ResponseEntity<Pelicula>(objeto, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Pelicula obj) {
		Pelicula pel = service.registrar(obj);
		
		// localhost:8080/peliculas/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pel.getIdPelicula()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Pelicula> modificar(@Valid @RequestBody Pelicula obj) {
		Pelicula objeto = service.modificar(obj);
		return new ResponseEntity<Pelicula>(objeto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
