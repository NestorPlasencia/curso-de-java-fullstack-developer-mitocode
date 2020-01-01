package com.mitocode.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class VentaComidaPK implements Serializable {

	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false, foreignKey = @ForeignKey(name = "fk_venta_comida"))
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "id_comida", nullable = false, foreignKey = @ForeignKey(name = "fk_comida_venta"))
	private Comida comida;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comida == null) ? 0 : comida.hashCode());
		result = prime * result + ((venta == null) ? 0 : venta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VentaComidaPK other = (VentaComidaPK) obj;
		if (comida == null) {
			if (other.comida != null)
				return false;
		} else if (!comida.equals(other.comida))
			return false;
		if (venta == null) {
			if (other.venta != null)
				return false;
		} else if (!venta.equals(other.venta))
			return false;
		return true;
	}

}
