package com.mitocode.repo;

import com.mitocode.model.Persona;

public class PersonaRepoImpl implements IPersonaRepo{

	@Override
	public void saludar(Persona per) {		
		System.out.println(per.getNombre());
	}

}
