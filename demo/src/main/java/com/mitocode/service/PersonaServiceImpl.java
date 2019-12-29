package com.mitocode.service;

import com.mitocode.model.Persona;
import com.mitocode.repo.IPersonaRepo;
import com.mitocode.repo.PersonaRepoImpl;

public class PersonaServiceImpl implements IPersonaService{
	
	private IPersonaRepo repo = new PersonaRepoImpl();

	@Override
	public void saludar(Persona per) {
		repo.saludar(per);
		
	}

}
