package com.mitocode.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mitocode.model.Persona;
import com.mitocode.repo.IPersonaRepo;

public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaRepo repo;// = new PersonaRepoImpl();		
	
	@Override
	public void saludar(Persona per) {
		repo.saludar(per);
	}

}
