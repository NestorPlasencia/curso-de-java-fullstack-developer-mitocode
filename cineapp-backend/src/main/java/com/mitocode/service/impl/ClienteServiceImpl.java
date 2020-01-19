package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Cliente;
import com.mitocode.repo.IClienteRepo;
import com.mitocode.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepo repo;
	
	@Override
	public Cliente registrar(Cliente cli) {
		return repo.save(cli);
	}

	@Override
	public Cliente modificar(Cliente cli) {
		return repo.save(cli);
	}

	@Override
	public List<Cliente> listar() {
		return repo.findAll();
	}

	@Override
	public Cliente listarPorId(Integer id) { 
		Optional<Cliente> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Cliente();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
