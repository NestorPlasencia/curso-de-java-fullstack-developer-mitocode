package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Comida;

public interface IComidaRepo extends JpaRepository<Comida, Integer>{

}
