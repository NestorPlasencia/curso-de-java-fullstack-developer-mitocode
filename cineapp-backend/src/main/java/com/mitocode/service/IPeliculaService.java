package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Pelicula;

public interface IPeliculaService {

	Pelicula registrar(Pelicula pel);
	Pelicula modificar(Pelicula pel);
	List<Pelicula> listar();
	Pelicula listarPorId(Integer id);
	void eliminar(Integer id);
}
