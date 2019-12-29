package com.mitocode.repo;

import org.springframework.stereotype.Repository;

import com.mitocode.model.Persona;

@Repository
public class PersonaRepoImpl implements IPersonaRepo{

	@Override
	public void saludar(Persona per) {		
		System.out.println(per.getNombre());
	}

}
