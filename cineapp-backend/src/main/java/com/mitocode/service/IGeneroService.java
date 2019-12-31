package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Genero;

public interface IGeneroService {

	Genero registrar(Genero gen);
	Genero modificar(Genero gen);
	List<Genero> listar();
	Genero listarPorId(Integer id);
	void eliminar(Integer id);
}
