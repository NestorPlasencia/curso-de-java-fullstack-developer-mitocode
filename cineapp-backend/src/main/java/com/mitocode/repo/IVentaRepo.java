package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Venta;

public interface IVentaRepo extends JpaRepository<Venta, Integer>{

}
