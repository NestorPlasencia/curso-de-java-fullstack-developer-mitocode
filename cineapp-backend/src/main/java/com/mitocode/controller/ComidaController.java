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

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Comida;
import com.mitocode.service.IComidaService;

@RestController
@RequestMapping("/comidas")
public class ComidaController {

	@Autowired
	private IComidaService service;
	
	@GetMapping
	public ResponseEntity<List<Comida>> listar(){
		List<Comida> lista = service.listar();
		return new ResponseEntity<List<Comida>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Comida> listarPorId(@PathVariable("id") Integer id){
		Comida obj = service.listarPorId(id);
		if(obj.getIdComida() == null) {
			throw new ModeloNotFoundException("ID NO EXISTE: " + id);
		}
		return new ResponseEntity<Comida>(obj, HttpStatus.OK);
	}
	
	/*@PostMapping
	public ResponseEntity<Comida> registrar(@RequestBody Comida obj) {
		Comida objeto = service.registrar(obj);
		return new ResponseEntity<Comida>(objeto, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Comida obj) {
		Comida com = service.registrar(obj);
		
		// localhost:8080/comidas/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(com.getIdComida()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Comida> modificar(@Valid @RequestBody Comida obj) {
		Comida objeto = service.modificar(obj);
		return new ResponseEntity<Comida>(objeto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Comida obj = service.listarPorId(id);
		if(obj.getIdComida() == null) {
			throw new ModeloNotFoundException("ID NO EXISTE: " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
