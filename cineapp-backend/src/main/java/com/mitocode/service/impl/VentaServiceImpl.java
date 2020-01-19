package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Venta;
import com.mitocode.repo.IVentaRepo;
import com.mitocode.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaRepo repo;
	
	@Override
	public Venta registrar(Venta ven) {
		return repo.save(ven);
	}

	@Override
	public Venta modificar(Venta ven) {
		return repo.save(ven);
	}

	@Override
	public List<Venta> listar() {
		return repo.findAll();
	}

	@Override
	public Venta listarPorId(Integer id) { 
		Optional<Venta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Venta();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
