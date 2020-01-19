package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer>{

}
