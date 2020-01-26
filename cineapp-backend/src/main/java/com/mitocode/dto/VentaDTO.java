package com.mitocode.dto;

import java.util.List;

import com.mitocode.model.Comida;
import com.mitocode.model.Venta;

public class VentaDTO {

	private Venta venta;
	private List<Comida> lstComidas;

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public List<Comida> getLstComidas() {
		return lstComidas;
	}

	public void setLstComidas(List<Comida> lstComidas) {
		this.lstComidas = lstComidas;
	}

}
