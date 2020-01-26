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

import com.mitocode.dto.VentaDTO;
import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Venta;
import com.mitocode.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	private IVentaService service;
	
	@GetMapping
	public ResponseEntity<List<Venta>> listar(){
		List<Venta> lista = service.listar();
		return new ResponseEntity<List<Venta>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Venta> listarPorId(@PathVariable("id") Integer id){
		Venta obj = service.listarPorId(id);
		if(obj.getIdVenta() == null) {
			throw new ModeloNotFoundException("ID NO EXISTE: " + id);
		}
		return new ResponseEntity<Venta>(obj, HttpStatus.OK);
	}
	
	/*@PostMapping
	public ResponseEntity<Venta> registrar(@RequestBody Venta obj) {
		Venta objeto = service.registrar(obj);
		return new ResponseEntity<Venta>(objeto, HttpStatus.CREATED);
	}*/
	
	/*@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Venta obj) {
		Venta ven = service.registrar(obj);
		
		// localhost:8080/ventas/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ven.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody VentaDTO obj) {
		Venta ven = service.registrarTransaccional(obj);
		
		// localhost:8080/ventas/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ven.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
	}

	
	@PutMapping
	public ResponseEntity<Venta> modificar(@Valid @RequestBody Venta obj) {
		Venta objeto = service.modificar(obj);
		return new ResponseEntity<Venta>(objeto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Venta obj = service.listarPorId(id);
		if(obj.getIdVenta() == null) {
			throw new ModeloNotFoundException("ID NO EXISTE: " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
