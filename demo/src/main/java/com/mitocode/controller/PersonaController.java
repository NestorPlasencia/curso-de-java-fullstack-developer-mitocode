package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@RestController
public class PersonaController {

	@Autowired
	private IPersonaService service;
	
	@GetMapping
	public Persona saludar() {
		Persona per = new Persona();
		per.setIdPersona(1);
		per.setNombre("Jaime");
		service.saludar(per);
		return per;
	}
}
